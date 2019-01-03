package com.feng.baby.application.service;

import com.feng.baby.application.command.CreateOrderGoodsInfo;
import com.feng.baby.model.*;
import com.feng.baby.support.exception.ResourceNotFoundException;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Record5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static sprout.jooq.generate.Tables.*;

@Slf4j
@Service
public class OrderService {

    private final DSLContext jooq;
    private final GoodsService goodsService;

    @Autowired
    OrderService(DSLContext jooq, GoodsService goodsService) {
        this.jooq = jooq;
        this.goodsService = goodsService;
    }

    @Transactional
    public void createOrder(String username, List<CreateOrderGoodsInfo> goodsInfos, String addressId, String couponId,
                            String remark, OrderType orderType, String groupBookingId, String cutDownId) {

        final Double[] totalAmount = {0.0};
        final Double[] discount = {0.0};
        String orderId = UUID.randomUUID().toString();

        //创建总订单
        jooq.insertInto(ORDERS)
                .set(ORDERS.ORDERS_ID, orderId)
                .set(ORDERS.USERNAME, username)
                .set(ORDERS.STATUS, OrderStatus.INIT.name())
                .set(ORDERS.REMARK, remark)
                .set(ORDERS.ORDER_TYPE, orderType.name())
                .execute();

        //查找红包，获取红包金额，减去红包金额
        jooq.selectFrom(COUPONS_USERS)
                .where(COUPONS_USERS.USER_NAME.eq(username))
                .and(COUPONS_USERS.COUPON_ID.eq(couponId))
                .and(COUPONS_USERS.IS_USED.isFalse())
                .fetchOptional().ifPresent(coupon -> {
            discount[0] = coupon.getAmountOfMoney();
            jooq.update(COUPONS_USERS)
                    .set(COUPONS_USERS.ORDERS_ID, orderId)
                    .set(COUPONS_USERS.IS_USED, true)
                    .execute();
        });

        //如果订单是砍价类型，查找发起订单时，已经砍价了多少了, 如果是 拼团类型 INIT > WAITING_GROUP
        switch (orderType) {
            case CUT_DOWN: {
                //查找砍价信息
                jooq.selectFrom(GOODS_CUT_DOWNS)
                        .where(GOODS_CUT_DOWNS.CUT_DOWN_ID.eq(cutDownId))
                        .fetchOptional()
                        .ifPresent(cutDown -> {
                            discount[0] = discount[0] + cutDown.getCutTotalAmount();
                            discount[0] = new BigDecimal(discount[0]).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                            jooq.update(GOODS_CUT_DOWNS)
                                    .set(GOODS_CUT_DOWNS.STATUS, CutDownStatus.FINISH.name())
                                    .where(GOODS_CUT_DOWNS.CUT_DOWN_ID.eq(cutDownId))
                                    .execute();
                        });
            }
            case GROUP_BOOKING: {
                //更新拼团状态
                jooq.update(GROUP_BOOKING).set(GROUP_BOOKING.STATUS, GroupBookingStatus.WAITING_GROUP.name())
                        .where(GROUP_BOOKING.GROUP_BOOKING_ID.eq(groupBookingId)).execute();
            }
            case SHOPPING_CART: {//删除购物车数据
                jooq.deleteFrom(SHOPPING_CART)
                        .where(SHOPPING_CART.SHOPPING_CART_ID.in(
                                goodsInfos.stream().map(CreateOrderGoodsInfo::getShoppingCartId).collect(Collectors.toSet())
                        )).and(SHOPPING_CART.USERNAME.eq(username)).execute();
                break;
            }
            default: {
                log.info("nothing to do");
            }
        }

        //获取寄送地址，填入寄送地址
        jooq.selectFrom(USER_ADDRESS).where(USER_ADDRESS.USER_ADDRESS_ID.eq(addressId)).fetchOptional().ifPresent(address -> {
            jooq.insertInto(ORDER_TRANSPORT)
                    .set(ORDER_TRANSPORT.TRANSPORT_ID, UUID.randomUUID().toString())
                    .set(ORDER_TRANSPORT.ORDERS_ID, orderId)
                    .set(ORDER_TRANSPORT.ADDRESS, address.getProvince() + address.getCity() + address.getAddress())
                    .set(ORDER_TRANSPORT.LINK_MAN, address.getLinkMan())
                    .set(ORDER_TRANSPORT.MOBILE, address.getMobile())
                    .execute();
        });

        //处理订单明细
        goodsInfos.forEach(goods -> totalAmount[0] = totalAmount[0] + insertOrderDetails(goods, orderId, orderType));


        //更新总订单中的折扣金额
        jooq.update(ORDERS)
                .set(ORDERS.ORIGINAL_PRICE, new BigDecimal(totalAmount[0]).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue())
                .set(ORDERS.DISCOUNT, new BigDecimal(discount[0]).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue())
                //TODO discount = 红包 or 砍价 实际金额应该还要考虑运费等
                .set(ORDERS.ACTUAL_PRICE, new BigDecimal(totalAmount[0] - discount[0]).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue())
                .where(ORDERS.ORDERS_ID.eq(orderId))
                .execute();

        log.error("total0 ->" + totalAmount[0] + "discount0 ->" + discount[0]);

    }

    @Transactional
    public Double insertOrderDetails(CreateOrderGoodsInfo goods, String orderId, OrderType orderType) {

        String detailId = UUID.randomUUID().toString();

        Record5<String, String, Double, String, String> result = jooq.select(
                GOODS.NAME.as("goods_name"),
                GOODS.MAIN_PIC.as("goods_pic"),
                GOODS_PRICE.PRICE.as("unit_price"),
                GOODS_PRICE.GOODS_LABEL.as("goods_label"),
                GOODS.GOODS_ID.as("goods_id")
        )
                .from(GOODS)
                .leftJoin(GOODS_PRICE).on(GOODS.GOODS_ID.eq(GOODS_PRICE.GOODS_ID))
                .where(GOODS.GOODS_ID.eq(goods.getGoodsId()))
                .and(GOODS_PRICE.PROPERTIES_JOINT.eq(goods.getPropertyChildIds()))
                .and(GOODS_PRICE.TYPE.eq(PriceType.valueOf(orderType.getPriceType()).name()))
                .fetchOptional().orElseThrow(ResourceNotFoundException::new);

        String goodsName = result.value1();
        String goodsPic = result.value2();
        Double unitPrice = result.value3();
        String goodsLabel = result.value4();
        String goodsId = result.value5();

        Double totalAmount = unitPrice * goods.getBuyNumber();

        jooq.insertInto(ORDER_DETAIL)
                .set(ORDER_DETAIL.DETAIL_ID, detailId)
                .set(ORDER_DETAIL.ORDERS_ID, orderId)
                .set(ORDER_DETAIL.GOODS_NAME, goodsName)
                .set(ORDER_DETAIL.GOODS_LABEL, goodsLabel)
                .set(ORDER_DETAIL.BUY_NUMBER, goods.getBuyNumber())
                .set(ORDER_DETAIL.UNIT_PRICE, unitPrice)
                .set(ORDER_DETAIL.AMOUNT, totalAmount)
                .set(ORDER_DETAIL.GOODS_ID, goodsId)
                .set(ORDER_DETAIL.GOODS_PIC, goodsPic)
                .execute();

        log.error("total ->" + totalAmount + "unitPrice ->" + unitPrice + "number ->" + goods.getBuyNumber());

        return totalAmount;
    }

    public Map<String, Object> statistics(String username) {
        //查询购物车中商品数量
        Integer shopCarNumber = goodsService.getShopCarBuyNumber(username);

        //查询待支付订单数量
        return ImmutableMap.of(
                "shopCarNumber", shopCarNumber,
                "count_id_no_transfer", 0,
                "count_id_no_pay", 8,
                "count_id_no_confirm", 0,
                "count_id_success", 4
        );
    }
}
