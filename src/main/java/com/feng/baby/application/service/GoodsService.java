package com.feng.baby.application.service;

import com.feng.baby.application.command.AddMediaCommand;
import com.feng.baby.application.command.AddPriceCommand;
import com.feng.baby.application.command.CreateGoodsCommand;
import com.feng.baby.application.representation.*;
import com.feng.baby.model.EvaluateType;
import com.feng.baby.model.OrderPriceType;
import com.feng.baby.support.exception.ResourceNotFoundException;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record10;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sprout.jooq.generate.tables.records.GoodsCategoryRecord;
import sprout.jooq.generate.tables.records.GoodsRecord;
import sprout.jooq.generate.tables.records.PropertiesRecord;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static sprout.jooq.generate.Tables.*;

@Slf4j
@Service
public class GoodsService {

    private final DSLContext jooq;

    @Autowired
    GoodsService(DSLContext jooq, GoodsPriceService goodsPriceService) {
        this.jooq = jooq;
        this.goodsPriceService = goodsPriceService;
    }

    private final GoodsPriceService goodsPriceService;

    public GoodsInfo goodsDetails(String goodsId) {

        GoodsRecord goodsRecord = jooq.selectFrom(GOODS).where(GOODS.GOODS_ID.eq(goodsId)).fetchOptional().get();

        //查找主信息
        BasicInfo basicInfo = jooq.selectFrom(GOODS).where(GOODS.GOODS_ID.eq(goodsId)).fetchOptionalInto(BasicInfo.class)
                .orElseThrow(ResourceNotFoundException::new);

        //查找商品价格
        Map<String, Object> priceInfo = goodsPriceService.getPriceInfo(goodsId);
        basicInfo.setPrice(priceInfo);

        //查找类型信息(尺寸、颜色...)
        Result<Record10<Integer, String, Integer, String, Integer, String, String, Integer, String, String>> result = jooq.select(
                PROPERTIES.ID,
                PROPERTIES.PROPERTIES_ID,
                PROPERTIES.INDEXS,
                PROPERTIES.NAME,
                PROPERTIES_DETAIL.ID.as("detail_id"),
                PROPERTIES_DETAIL.DETAIL_ID.as("detail_detail_id"),
                PROPERTIES_DETAIL.PROPERTIES_ID.as("detail_properties_id"),
                PROPERTIES_DETAIL.INDEXS.as("detail_indexs"),
                PROPERTIES_DETAIL.NAME.as("detail_name"),
                PROPERTIES_DETAIL.REMARK.as("detail_remark"))
                .from(PROPERTIES)
                .innerJoin(PROPERTIES_DETAIL).on(PROPERTIES.PROPERTIES_ID.eq(PROPERTIES_DETAIL.PROPERTIES_ID))
                .where(PROPERTIES.GOODS_ID.eq(goodsId))
                .fetch();

        Map<PropertiesRecord, Result<Record10<Integer, String, Integer, String, Integer, String, String, Integer, String, String>>> propertiesRecordResultMap = result.intoGroups(PROPERTIES);

        List<Properties> properties = propertiesRecordResultMap.entrySet().stream().map(record -> {
            Properties propertie = Properties.toProperties(record.getKey());
            propertie.setChildsCurGoods(
                    record.getValue().stream().map(value ->
                            PropertiesDetail.builder()
                                    .id(value.value5())
                                    .detailId(value.value6())
                                    .propertiesId(value.value7())
                                    .indexs(value.value8())
                                    .name(value.value9())
                                    .remark(value.value10())
                                    .build()
                    ).collect(Collectors.toList())
            );
            return propertie;
        }).collect(Collectors.toList());

        //查找媒体信息
        List<GoodsMedia> goodsMedia = jooq.selectFrom(GOODS_MEDIA).where(GOODS_MEDIA.GOODS_ID.eq(goodsId)).fetchInto(GoodsMedia.class);

        return new GoodsInfo(basicInfo, properties, goodsMedia);
    }

    //检测商品是否是喜欢的
    public Map<String, Boolean> checkFav(String goodsId) {
        boolean isPresent = jooq.selectFrom(GOODS_FAV).where(GOODS_FAV.GOODS_ID.eq(goodsId)).fetchOptional().isPresent();
        return ImmutableMap.of("fav", isPresent);
    }

    public Page<BasicInfo> topgoods(Pageable pageable) {
        int count = jooq.fetchCount(GOODS.leftJoin(GOODS_RECOMMEND).on(GOODS.GOODS_ID.eq(GOODS_RECOMMEND.GOODS_ID)));

        List<BasicInfo> basicInfos = jooq.select(
                GOODS.ID, GOODS.GOODS_ID, GOODS.NAME,
                GOODS.MAIN_PIC, GOODS.CATEGORY_ID, GOODS.CHARACTERISTIC,
                GOODS.IS_SUPPORT_GROUP, GOODS.IS_REMOVE, GOODS.CREATED_AT, GOODS.NUMBER_FAV,
                GOODS.NUMBER_ORDERS, GOODS.NUMBER_REPUTATION, GOODS.REMARK, GOODS.STORES, GOODS.VIEWS
        ).from(GOODS.leftJoin(GOODS_RECOMMEND).on(GOODS.GOODS_ID.eq(GOODS_RECOMMEND.GOODS_ID)))
                .offset(pageable.getOffset()).limit(pageable.getPageSize())
                .fetchInto(BasicInfo.class);

        basicInfos.forEach(basicInfo -> basicInfo.setPrice(goodsPriceService.getPriceInfo(basicInfo.getGoodsId())));


        return new PageImpl<>(basicInfos, pageable, count);
    }

    public Page<BasicInfo> toptuan(Pageable pageable) {
        int count = jooq.fetchCount(GOODS.leftJoin(GROUP_BOOKING).on(GOODS.GOODS_ID.eq(GROUP_BOOKING.GOODS_ID)));

        List<BasicInfo> basicInfos = jooq.select(
                GOODS.ID, GOODS.GOODS_ID, GOODS.NAME,
                GOODS.MAIN_PIC, GOODS.CATEGORY_ID, GOODS.CHARACTERISTIC,
                GOODS.IS_SUPPORT_GROUP, GOODS.IS_REMOVE, GOODS.CREATED_AT, GOODS.NUMBER_FAV,
                GOODS.NUMBER_ORDERS, GOODS.NUMBER_REPUTATION, GOODS.REMARK, GOODS.STORES, GOODS.VIEWS
        ).from(GOODS.leftJoin(GROUP_BOOKING).on(GOODS.GOODS_ID.eq(GROUP_BOOKING.GOODS_ID)))
                .offset(pageable.getOffset()).limit(pageable.getPageSize())
                .fetchInto(BasicInfo.class);

        basicInfos.forEach(basicInfo -> basicInfo.setPrice(goodsPriceService.getPriceInfo(basicInfo.getGoodsId())));

        return new PageImpl<>(basicInfos, pageable, count);
    }


    public Page<BasicInfo> similar(String categoryId, Pageable pageable) {

        Condition condition = GOODS.CATEGORY_ID.eq(categoryId);

        int count = jooq.fetchCount(GOODS.leftJoin(GOODS_CUT_DOWN_INFO).on(GOODS.GOODS_ID.eq(GOODS_CUT_DOWN_INFO.GOODS_ID)), condition);

        List<BasicInfo> basicInfos = jooq.select(
                GOODS.ID, GOODS.GOODS_ID, GOODS.NAME,
                GOODS.MAIN_PIC, GOODS.CATEGORY_ID, GOODS.CHARACTERISTIC,
                GOODS.IS_SUPPORT_GROUP, GOODS.IS_REMOVE, GOODS.CREATED_AT, GOODS.NUMBER_FAV,
                GOODS.NUMBER_ORDERS, GOODS.NUMBER_REPUTATION, GOODS.REMARK, GOODS.STORES, GOODS.VIEWS
        ).from(GOODS.leftJoin(GOODS_CUT_DOWN_INFO).on(GOODS.GOODS_ID.eq(GOODS_CUT_DOWN_INFO.GOODS_ID)))
                .where(condition)
                .offset(pageable.getOffset()).limit(pageable.getPageSize())
                .fetchInto(BasicInfo.class);

        basicInfos.forEach(basicInfo -> basicInfo.setPrice(goodsPriceService.getPriceInfo(basicInfo.getGoodsId())));

        return new PageImpl<>(basicInfos, pageable, count);
    }

    @Transactional
    public void newFav(String goodsId, String username) {
        jooq.insertInto(GOODS_FAV)
                .set(GOODS_FAV.GOODS_ID, goodsId)
                .set(GOODS_FAV.USERNAME, username)
                .execute();
    }

    public void favDelete(String goodsId, String username) {
        jooq.delete(GOODS_FAV)
                .where(GOODS_FAV.GOODS_ID.eq(goodsId))
                .and(GOODS_FAV.USERNAME.eq(username))
                .execute();
    }

    public Page<GoodsFav> favList(String username, Pageable pageable) {
        Condition condition = GOODS_FAV.USERNAME.eq(username);

        int count = jooq.fetchCount(GOODS_FAV.leftJoin(GOODS).on(GOODS_FAV.GOODS_ID.eq(GOODS.GOODS_ID)), condition);

        List<GoodsFav> goodsPic = jooq.select(GOODS_FAV.GOODS_ID,
                GOODS_FAV.USERNAME,
                GOODS_FAV.CREATED_AT.as("addTime"),
                GOODS.NAME,
                GOODS.MAIN_PIC.as("goodsPic"))
                .from(GOODS_FAV)
                .leftJoin(GOODS).on(GOODS_FAV.GOODS_ID.eq(GOODS.GOODS_ID))
                .where(condition)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchInto(GoodsFav.class);

        return new PageImpl<>(goodsPic, pageable, count);
    }

    public Page<BasicInfo> search(String keyWord, String categoryId, Pageable pageable) {

        Condition condition = GOODS.IS_REMOVE.isFalse();

        if (StringUtils.isNotEmpty(keyWord)) {
            condition = condition.and(GOODS.NAME.likeIgnoreCase("%" + keyWord + "%")
                    .or(GOODS.CHARACTERISTIC.likeIgnoreCase("%" + keyWord + "%")));
        }

        if (StringUtils.isNotEmpty(categoryId)) {
            condition = condition.and(GOODS.CATEGORY_ID.eq(categoryId));
        }

        int count = jooq.fetchCount(GOODS, condition);

        List<BasicInfo> basicInfos = jooq.select(
                GOODS.ID, GOODS.GOODS_ID, GOODS.NAME,
                GOODS.MAIN_PIC, GOODS.CATEGORY_ID, GOODS.CHARACTERISTIC,
                GOODS.IS_SUPPORT_GROUP, GOODS.IS_REMOVE, GOODS.CREATED_AT, GOODS.NUMBER_FAV,
                GOODS.NUMBER_ORDERS, GOODS.NUMBER_REPUTATION, GOODS.REMARK, GOODS.STORES, GOODS.VIEWS
        )
                .from(GOODS)
                .where(condition)
                .offset(pageable.getOffset()).limit(pageable.getPageSize())
                .fetchInto(BasicInfo.class);

        basicInfos.forEach(basicInfo -> basicInfo.setPrice(goodsPriceService.getPriceInfo(basicInfo.getGoodsId())));

        return new PageImpl<>(basicInfos, pageable, count);
    }

    public void addShopCar(String shoppingCartId, String username, String goodsId, String propertyChildIds, Integer buyNumber) {
        jooq.insertInto(SHOPPING_CART)
                .set(SHOPPING_CART.SHOPPING_CART_ID, StringUtils.isEmpty(shoppingCartId) ? UUID.randomUUID().toString() : shoppingCartId)
                .set(SHOPPING_CART.USERNAME, username)
                .set(SHOPPING_CART.GOODS_ID, goodsId)
                .set(SHOPPING_CART.PROPERTIES_JOINT, propertyChildIds)
                .set(SHOPPING_CART.BUY_NUMBER, buyNumber)
                .onDuplicateKeyUpdate()
                .set(SHOPPING_CART.USERNAME, username)
                .set(SHOPPING_CART.GOODS_ID, goodsId)
                .set(SHOPPING_CART.PROPERTIES_JOINT, propertyChildIds)
                .set(SHOPPING_CART.BUY_NUMBER, buyNumber)
                .execute();
    }

    public Map<String, Object> getShopCar(String username) {
        List<ShopCar> shopCars = jooq.select(SHOPPING_CART.SHOPPING_CART_ID,
                SHOPPING_CART.CREATED_AT,
                SHOPPING_CART.GOODS_ID,
                SHOPPING_CART.USERNAME,
                SHOPPING_CART.PROPERTIES_JOINT.as("propertyChildIds"),
                SHOPPING_CART.BUY_NUMBER,
                GOODS.MAIN_PIC.as("pic"),
                GOODS.NAME,
                GOODS_PRICE.GOODS_LABEL.as("label"),
                GOODS_PRICE.PRICE
        )
                .from(SHOPPING_CART)
                .leftJoin(GOODS).on(SHOPPING_CART.GOODS_ID.eq(GOODS.GOODS_ID))
                .leftJoin(GOODS_PRICE).on(GOODS_PRICE.PROPERTIES_JOINT.eq(SHOPPING_CART.PROPERTIES_JOINT))
                .where(SHOPPING_CART.USERNAME.eq(username))
                .and(GOODS_PRICE.TYPE.eq(OrderPriceType.CHEAP.name()))
                .fetchInto(ShopCar.class);

        Integer buyNumber = shopCars.stream().map(ShopCar::getBuyNumber).reduce(Integer::sum).orElse(0);

        return ImmutableMap.of("list", shopCars, "buyNumber", buyNumber);
    }

    public void deleteShopCar(String username, String[] goodsIds) {
        jooq.deleteFrom(SHOPPING_CART)
                .where(SHOPPING_CART.GOODS_ID.in(goodsIds))
                .and(SHOPPING_CART.USERNAME.eq(username))
                .execute();
    }

    public void updateShopCar(String username, String shoppingCartId, Integer buyNumber) {
        jooq.update(SHOPPING_CART)
                .set(SHOPPING_CART.BUY_NUMBER, buyNumber)
                .where(SHOPPING_CART.USERNAME.eq(username))
                .and(SHOPPING_CART.SHOPPING_CART_ID.eq(shoppingCartId))
                .execute();
    }

    public Integer getShopCarBuyNumber(String username) {
        return jooq.select(SHOPPING_CART.BUY_NUMBER)
                .from(SHOPPING_CART)
                .where(SHOPPING_CART.USERNAME.eq(username))
                .fetch(SHOPPING_CART.BUY_NUMBER).stream().reduce(Integer::sum)
                .orElse(0);
    }

    public Page<BasicInfo> guessLike(String username, Pageable pageable) {
        //查找我最近的浏览记录，获取感兴趣的商品

        int count = jooq.fetchCount(GOODS);

        List<BasicInfo> basicInfos = jooq.select(
                GOODS.ID, GOODS.GOODS_ID, GOODS.NAME,
                GOODS.MAIN_PIC, GOODS.CATEGORY_ID, GOODS.CHARACTERISTIC,
                GOODS.IS_SUPPORT_GROUP, GOODS.IS_REMOVE, GOODS.CREATED_AT, GOODS.NUMBER_FAV,
                GOODS.NUMBER_ORDERS, GOODS.NUMBER_REPUTATION, GOODS.REMARK, GOODS.STORES, GOODS.VIEWS
        ).from(GOODS.leftJoin(GOODS_CUT_DOWN_INFO).on(GOODS.GOODS_ID.eq(GOODS_CUT_DOWN_INFO.GOODS_ID)))
                .offset(pageable.getOffset()).limit(pageable.getPageSize())
                .fetchInto(BasicInfo.class);

        basicInfos.forEach(basicInfo -> basicInfo.setPrice(goodsPriceService.getPriceInfo(basicInfo.getGoodsId())));

        return new PageImpl<>(basicInfos, pageable, count);
    }

    @Transactional
    public void createGoods(String categoryId, String name, String characteristic, String mainPic,
                            boolean supportGroup, String remark, String content, List<CreateGoodsCommand.GoodsProperties> properties) {
        String goodsId = UUID.randomUUID().toString();

        jooq.selectFrom(CATEGORY).where(CATEGORY.CATEGORY_ID.eq(categoryId)).fetchOptional().orElseThrow(ResourceNotFoundException::new);

        jooq.insertInto(GOODS)
                .set(GOODS.GOODS_ID, goodsId)
                .set(GOODS.CATEGORY_ID, categoryId)
                .set(GOODS.NAME, name)
                .set(GOODS.CHARACTERISTIC, characteristic)
                .set(GOODS.MAIN_PIC, mainPic)
                .set(GOODS.IS_SUPPORT_GROUP, supportGroup)
                .set(GOODS.CONTENT, content)
                .set(GOODS.REMARK, remark)

                .set(GOODS.NUMBER_ORDERS, 0)
                .set(GOODS.VIEWS, 0)
                .set(GOODS.NUMBER_FAV, 0)
                .set(GOODS.STORES, 0)
                .set(GOODS.NUMBER_REPUTATION, 0)

                .execute();

        properties.forEach(property -> {
            String propertyId = UUID.randomUUID().toString();

            jooq.insertInto(PROPERTIES)
                    .set(PROPERTIES.PROPERTIES_ID, propertyId)
                    .set(PROPERTIES.INDEXS, property.getIndex())
                    .set(PROPERTIES.NAME, property.getName())
                    .execute();

            Arrays.asList(property.getLabel()).forEach(detail -> jooq.insertInto(PROPERTIES_DETAIL)
                    .set(PROPERTIES_DETAIL.DETAIL_ID, UUID.randomUUID().toString())
                    .set(PROPERTIES_DETAIL.PROPERTIES_ID, propertyId)
                    .set(PROPERTIES_DETAIL.INDEXS, 1)
                    .set(PROPERTIES_DETAIL.NAME, detail)
                    .execute());
        });

        //TODO 如果支持拼团和砍价  发送消息  创建拼团砍价信息

    }

    @Transactional
    public void addPrice(String goodsId, List<AddPriceCommand.Price> prices) {
        jooq.selectFrom(GOODS).where(GOODS.GOODS_ID.eq(goodsId)).fetchOptional().orElseThrow(ResourceNotFoundException::new);

        prices.forEach(price -> price.getPrice().forEach((k, v) -> {
            jooq.insertInto(GOODS_PRICE)
                    .set(GOODS_PRICE.GOODS_ID, goodsId)
                    .set(GOODS_PRICE.PROPERTIES_JOINT, price.getPropertiesJoint())
                    .set(GOODS_PRICE.GOODS_LABEL, price.getGoodsLabel())
                    .set(GOODS_PRICE.TYPE, k)
                    .set(GOODS_PRICE.PRICE, v)
                    .execute();
        }));
    }


    @Transactional
    public void makeEvaluate(String score, String pics, String username, String objectId, EvaluateType type, String content, String label) {
        jooq.insertInto(EVALUATE)
                .set(EVALUATE.EVALUATE_ID, UUID.randomUUID().toString())
                .set(EVALUATE.USERNAME, username)
                .set(EVALUATE.EVALUATE_SCORE, score)
                .set(EVALUATE.PICS, pics)
                .set(EVALUATE.OBJECT_ID, objectId)
                .set(EVALUATE.OBJECT_TYPE, type.name())
                .set(EVALUATE.CONTENT, content)
                .set(EVALUATE.LABEL, label)
                .execute();
    }


    public Page<EvaluateRepresentation> evaluates(String goodsId, EvaluateType evaluateType, Pageable pageable) {

        Condition condition = EVALUATE.OBJECT_ID.eq(goodsId).and(EVALUATE.OBJECT_TYPE.eq(evaluateType.name()));

        int count = jooq.fetchCount(EVALUATE, condition);

        List<EvaluateRepresentation> evaluateRepresentations = jooq.select(
                USER_INFO.USER_NAME, USER_INFO.AVATAR_URL, USER_INFO.NICK_NAME,
                EVALUATE.CREATED_AT, EVALUATE.EVALUATE_ID, EVALUATE.CONTENT, EVALUATE.PICS,
                EVALUATE.EVALUATE_SCORE, EVALUATE.LABEL, EVALUATE.IS_REPLY)
                .from(EVALUATE)
                .leftJoin(USER_INFO).on(USER_INFO.USER_NAME.eq(EVALUATE.USERNAME))
                .where(condition)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchInto(EvaluateRepresentation.class);

        evaluateRepresentations.stream().filter(EvaluateRepresentation::isHasReply).forEach(evaluate -> {
            List<EvaluateRepresentation> replies = jooq.select(USER_INFO.USER_NAME, USER_INFO.AVATAR_URL, USER_INFO.NICK_NAME, EVALUATE.CREATED_AT, EVALUATE.CONTENT)
                    .from(EVALUATE)
                    .leftJoin(USER_INFO).on(USER_INFO.USER_NAME.eq(EVALUATE.USERNAME))
                    .where(EVALUATE.OBJECT_ID.eq(evaluate.getEvaluateId()).and(EVALUATE.OBJECT_TYPE.eq(EvaluateType.REPLY.name())))
                    .fetchInto(EvaluateRepresentation.class);
            evaluate.setReply(replies);
        });


        return new PageImpl<>(evaluateRepresentations, pageable, count);
    }

    @Transactional
    public void deleteEvaluate(String evaluateId) {
        jooq.selectFrom(EVALUATE).where(EVALUATE.EVALUATE_ID.eq(evaluateId)).fetchOptional().ifPresent(evaluate -> {
            if(evaluate.getIsReply()){
                jooq.deleteFrom(EVALUATE).where(EVALUATE.OBJECT_ID.eq(evaluateId)).and(EVALUATE.OBJECT_TYPE.eq(EvaluateType.REPLY.name())).execute();
            }
            evaluate.delete();
        });
    }

    @Transactional
    public void reply(String objectId, String content) {
        jooq.update(EVALUATE).set(EVALUATE.IS_REPLY, true).where(EVALUATE.EVALUATE_ID.eq(objectId)).execute();
        jooq.insertInto(EVALUATE)
                .set(EVALUATE.USERNAME, "admin")
                .set(EVALUATE.OBJECT_TYPE, EvaluateType.REPLY.name())
                .set(EVALUATE.OBJECT_ID, objectId)
                .set(EVALUATE.CONTENT, content)
                .execute();
    }

    public void addMedia(String goodsId, List<AddMediaCommand.Media> medias) {
        medias.forEach(media -> jooq.insertInto(GOODS_MEDIA)
                .set(GOODS_MEDIA.GOODS_ID, goodsId)
                .set(GOODS_MEDIA.URL, media.getUrl())
                .set(GOODS_MEDIA.TYPE, media.getType())
                .execute());
    }
}
