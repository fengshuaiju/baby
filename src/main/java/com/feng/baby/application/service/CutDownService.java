package com.feng.baby.application.service;

import com.feng.baby.application.representation.BasicInfo;
import com.feng.baby.application.representation.CutDownInfo;
import com.feng.baby.application.representation.GoodsCutDownHelper;
import com.feng.baby.application.representation.UserInfo;
import com.feng.baby.model.CutDownStatus;
import com.feng.baby.model.OrderPriceType;
import com.feng.baby.model.OrderType;
import com.feng.baby.support.utils.ResourceNotFoundException;
import com.feng.baby.support.utils.Validate;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sprout.jooq.generate.tables.records.GoodsCutDownInfoRecord;
import sprout.jooq.generate.tables.records.GoodsCutDownsRecord;
import sprout.jooq.generate.tables.records.GoodsPriceRecord;
import sprout.jooq.generate.tables.records.GoodsRecord;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

import static sprout.jooq.generate.Tables.*;

@Slf4j
@Service
public class CutDownService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private GoodsPriceService goodsPriceService;


    @Autowired
    CutDownService(DSLContext jooq) {
        this.jooq = jooq;
    }

    private final DSLContext jooq;


    public Page<BasicInfo> cutdown(Pageable pageable) {
        int count = jooq.fetchCount(GOODS.leftJoin(GOODS_CUT_DOWN_INFO).on(GOODS.GOODS_ID.eq(GOODS_CUT_DOWN_INFO.GOODS_ID)));

        List<BasicInfo> basicInfos = jooq.select(
                GOODS.ID, GOODS.GOODS_ID, GOODS.NAME,
                GOODS.MAIN_PIC, GOODS.CATEGORY_ID, GOODS.CHARACTERISTIC,
                GOODS.PINGTUAN, GOODS.STATUS, GOODS.CREATED_AT, GOODS.NUMBER_FAV,
                GOODS.NUMBER_ORDERS, GOODS.NUMBER_REPUTATION, GOODS.REMARK, GOODS.STORES, GOODS.VIEWS
        ).from(GOODS.leftJoin(GOODS_CUT_DOWN_INFO).on(GOODS.GOODS_ID.eq(GOODS_CUT_DOWN_INFO.GOODS_ID)))
                .offset(pageable.getOffset()).limit(pageable.getPageSize())
                .fetchInto(BasicInfo.class);

        basicInfos.forEach(basicInfo -> basicInfo.setPrice(goodsPriceService.getPriceInfo(basicInfo.getGoodsId())));

        return new PageImpl<>(basicInfos, pageable, count);
    }


    public Map<String, Object> newCutDown(String goodsId, String username, String propertyChildIds, String goodsLabel, Integer buyNumber) {
        //查找砍价配置信息 goods_cut_down;
        //验证该商品是可以砍价的商品
        GoodsCutDownInfoRecord goodsCutDownInfo = jooq.selectFrom(GOODS_CUT_DOWN_INFO)
                .where(GOODS_CUT_DOWN_INFO.GOODS_ID.eq(goodsId))
                .fetchOptionalInto(GOODS_CUT_DOWN_INFO)
                .orElseThrow(ResourceNotFoundException::new);

        //检验砍价表中是否已存在该用户发起的该商品的砍价
        String isExistCutDownId = jooq.selectFrom(GOODS_CUT_DOWNS)
                .where(GOODS_CUT_DOWNS.GOODS_ID.eq(goodsId)).and(GOODS_CUT_DOWNS.INITIATOR.eq(username))
                .and(GOODS_CUT_DOWNS.STATUS.in(CutDownStatus.INIT.name(), CutDownStatus.IN_PROGRESS.name(), CutDownStatus.SUCCESS.name()))
                .fetchOptional(GOODS_CUT_DOWNS.CUT_DOWN_ID).orElse(null);
        if (isExistCutDownId != null) {
            return ImmutableMap.of("cutDownId", isExistCutDownId, "isNew", false);
        }


        //查询商品信息
        GoodsRecord goods = jooq.selectFrom(GOODS).where(GOODS.GOODS_ID.eq(goodsId))
                .fetchOptionalInto(GOODS).orElseThrow(ResourceNotFoundException::new);

        //查询价格配置
        GoodsPriceRecord price = jooq.selectFrom(GOODS_PRICE)
                .where(GOODS_PRICE.GOODS_ID.eq(goodsId))
                .and(GOODS_PRICE.PROPERTIES_JOINT.eq(propertyChildIds))
                .and(GOODS_PRICE.TYPE.eq(OrderPriceType.CUT_DOWN.name()))
                .fetchOptional()
                .orElseThrow(ResourceNotFoundException::new);

        //向砍价表中增加信息
        String cutDownsId = UUID.randomUUID().toString();
        jooq.insertInto(GOODS_CUT_DOWNS).set(GOODS_CUT_DOWNS.GOODS_ID, goodsId)
                .set(GOODS_CUT_DOWNS.GOODS_PIC, goods.getMainPic())
                .set(GOODS_CUT_DOWNS.GOODS_NAME, goods.getName())
                .set(GOODS_CUT_DOWNS.CUT_DOWN_ID, cutDownsId)
                .set(GOODS_CUT_DOWNS.INITIATOR, username)
                .set(GOODS_CUT_DOWNS.CURRENT_PRICE, price.getPrice())
                .set(GOODS_CUT_DOWNS.ORIGINAL_PRICE, price.getPrice())
                .set(GOODS_CUT_DOWNS.PROPERTIES_JOINT, propertyChildIds)
                .set(GOODS_CUT_DOWNS.BUY_NUMBER, buyNumber)
                .set(GOODS_CUT_DOWNS.GOODS_LABEL, goodsLabel)
                .set(GOODS_CUT_DOWNS.BASE_PRICE, new BigDecimal(price.getPrice() - goodsCutDownInfo.getMaxCutDown()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue())
                .set(GOODS_CUT_DOWNS.CUT_TOTAL_AMOUNT, 0.0)
                .set(GOODS_CUT_DOWNS.HELPER_NUMBER, 0)
                .set(GOODS_CUT_DOWNS.STATUS, CutDownStatus.INIT.name())
                .set(GOODS_CUT_DOWNS.CREATED_AT, LocalDateTime.now())
                .set(GOODS_CUT_DOWNS.EXPIRY_TIME_AT,
                        LocalDateTime.now().plusHours(goodsCutDownInfo.getEffectiveTime()))
                .execute();

        return ImmutableMap.of("cutDownId", cutDownsId, "isNew", true);

    }

    public CutDownInfo getCutDownInfo(String cutDownId) {
        CutDownInfo cutDownInfo = jooq.selectFrom(GOODS_CUT_DOWNS)
                .where(GOODS_CUT_DOWNS.CUT_DOWN_ID.eq(cutDownId))
                .fetchOptionalInto(CutDownInfo.class)
                .orElseThrow(ResourceNotFoundException::new);

        //获取创建者信息
        UserInfo userInfo = accountService.getUserInfoByUserName(cutDownInfo.getInitiator());

        LocalDateTime createdAt = cutDownInfo.getCreatedAt();
        LocalDateTime expiryTimeAt = cutDownInfo.getExpiryTimeAt();
        LocalDateTime nowTime = LocalDateTime.now();
        Validate.isTrue(createdAt.isBefore(expiryTimeAt), "time error");
        Validate.isTrue(nowTime.isBefore(expiryTimeAt), "time error");


        Duration between = Duration.between(nowTime, expiryTimeAt);
        cutDownInfo.setLeftSecond(between.getSeconds());

        //userInfo
        cutDownInfo.setNickName(userInfo.getNickName());
        cutDownInfo.setAvatarUrl(userInfo.getAvatarUrl());

        return cutDownInfo;
    }


    public GoodsCutDownHelper getMyHelp(String cutDownId, String username) {
        return jooq.select(GOODS_CUT_DOWN_HELPER.CUT_DOWN_ID,
                GOODS_CUT_DOWN_HELPER.CREATED_AT,
                GOODS_CUT_DOWN_HELPER.CUT_DOWN_PRICE,
                GOODS_CUT_DOWN_HELPER.PARTICIPANT,
                USER_INFO.NICK_NAME.as("participantNickName"),
                USER_INFO.AVATAR_URL.as("participantAvatarUrl")
        ).from(GOODS_CUT_DOWN_HELPER.leftJoin(USER_INFO).on(GOODS_CUT_DOWN_HELPER.PARTICIPANT.eq(USER_INFO.USER_NAME)))
                .where(GOODS_CUT_DOWN_HELPER.PARTICIPANT.eq(username))
                .and(GOODS_CUT_DOWN_HELPER.CUT_DOWN_ID.eq(cutDownId))
                .fetchOptionalInto(GoodsCutDownHelper.class)
                .orElse(null);
    }


    public void helpCutDown(String goodsId, String cutDownId, String participant) {
        //根据商品ID查询出商品的砍价配置信息
        GoodsCutDownInfoRecord goodsCutDownInfo = jooq.selectFrom(GOODS_CUT_DOWN_INFO)
                .where(GOODS_CUT_DOWN_INFO.GOODS_ID.eq(goodsId))
                .fetchOptionalInto(GOODS_CUT_DOWN_INFO)
                .orElseThrow(ResourceNotFoundException::new);

        //查询该砍价是否已经结束，已经砍掉的金额是否超出可坎的最大金额
        GoodsCutDownsRecord goodsCutDown = jooq.selectFrom(GOODS_CUT_DOWNS)
                .where(GOODS_CUT_DOWNS.CUT_DOWN_ID.eq(cutDownId))
                .and(GOODS_CUT_DOWNS.STATUS.in(CutDownStatus.INIT.name(), CutDownStatus.IN_PROGRESS.name()))
                .fetchOptionalInto(GOODS_CUT_DOWNS)
                .orElseThrow(ResourceNotFoundException::new);
        //已经砍掉的金额
        Double cutTotalAmount = goodsCutDown.getCutTotalAmount();
        //能够砍掉的最大金额
        Double canMaxCutDown = goodsCutDownInfo.getMaxCutDown();


        //如果已砍金额超过可砍金额，报错
        if (cutTotalAmount >= canMaxCutDown) {
            jooq.update(GOODS_CUT_DOWNS).set(GOODS_CUT_DOWNS.STATUS, CutDownStatus.SUCCESS.name()).execute();
            throw new IllegalStateException("goods cut downs already finished");
        }

        //TODO 要不要加上砍价人数的限制，如果人数达到，则不能再进行砍价

        //取出砍价的上下限,生成此次砍价的金额,并判定此次砍价后是否就结束砍价了
        Double maxAmountPerCut = goodsCutDownInfo.getMaxAmountPerCut();
        Double minAmountPerCut = goodsCutDownInfo.getMinAmountPerCut();

        double currentCutDown = Math.random() * (maxAmountPerCut - minAmountPerCut) + minAmountPerCut;

        if ((cutTotalAmount + currentCutDown) > canMaxCutDown) {
            currentCutDown = canMaxCutDown - currentCutDown;
            jooq.update(GOODS_CUT_DOWNS)
                    .set(GOODS_CUT_DOWNS.STATUS, CutDownStatus.SUCCESS.name())
                    .set(GOODS_CUT_DOWNS.HELPER_NUMBER, goodsCutDown.getHelperNumber() + 1)
                    .set(GOODS_CUT_DOWNS.CUT_TOTAL_AMOUNT, new BigDecimal(goodsCutDown.getCutTotalAmount() + currentCutDown).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue())
                    .set(GOODS_CUT_DOWNS.CURRENT_PRICE, new BigDecimal(goodsCutDown.getOriginalPrice() - currentCutDown - goodsCutDown.getCutTotalAmount()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue())
                    .where(GOODS_CUT_DOWNS.CUT_DOWN_ID.eq(cutDownId))
                    .execute();
        }

        //插入此次砍价的记录
        jooq.insertInto(GOODS_CUT_DOWN_HELPER)
                .set(GOODS_CUT_DOWN_HELPER.PARTICIPANT, participant)
                .set(GOODS_CUT_DOWN_HELPER.CUT_DOWN_PRICE, new BigDecimal(currentCutDown).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue())
                .set(GOODS_CUT_DOWN_HELPER.CUT_DOWN_ID, cutDownId)
                .execute();

        jooq.update(GOODS_CUT_DOWNS)
                .set(GOODS_CUT_DOWNS.HELPER_NUMBER, goodsCutDown.getHelperNumber() + 1)
                .set(GOODS_CUT_DOWNS.CUT_TOTAL_AMOUNT, new BigDecimal(goodsCutDown.getCutTotalAmount() + currentCutDown).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue())
                .set(GOODS_CUT_DOWNS.CURRENT_PRICE, new BigDecimal(goodsCutDown.getOriginalPrice() - currentCutDown - goodsCutDown.getCutTotalAmount()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue())
                .set(GOODS_CUT_DOWNS.STATUS, CutDownStatus.IN_PROGRESS.name())
                .where(GOODS_CUT_DOWNS.CUT_DOWN_ID.eq(cutDownId))
                .execute();
    }

    public List<GoodsCutDownHelper> getHelpers(String cutDownId) {
        return jooq.select(GOODS_CUT_DOWN_HELPER.CUT_DOWN_ID,
                GOODS_CUT_DOWN_HELPER.CREATED_AT,
                GOODS_CUT_DOWN_HELPER.CUT_DOWN_PRICE,
                GOODS_CUT_DOWN_HELPER.PARTICIPANT,
                USER_INFO.NICK_NAME.as("participantNickName"),
                USER_INFO.AVATAR_URL.as("participantAvatarUrl")
        ).from(GOODS_CUT_DOWN_HELPER.leftJoin(USER_INFO).on(GOODS_CUT_DOWN_HELPER.PARTICIPANT.eq(USER_INFO.USER_NAME)))
                .where(GOODS_CUT_DOWN_HELPER.CUT_DOWN_ID.eq(cutDownId))
                .fetchInto(GoodsCutDownHelper.class);
    }

    public Map<String, Object> checkExist(String username, String goodsId) {
        Map<String, Object> returnDate = new HashMap<>();

        jooq.select(GOODS_CUT_DOWNS.CUT_DOWN_ID)
                .from(GOODS_CUT_DOWNS)
                .where(GOODS_CUT_DOWNS.GOODS_ID.eq(goodsId))
                .and(GOODS_CUT_DOWNS.INITIATOR.eq(username))
                .fetchOptional().ifPresent(recored -> {
                    returnDate.put("exist", true);
                    returnDate.put("cutDownId", recored.value1());
                });

        return returnDate;
    }

    public Page<CutDownInfo> myCutList(String username, Pageable pageable) {

        Condition condition = GOODS_CUT_DOWNS.INITIATOR.eq(username);

        int count = jooq.fetchCount(GOODS_CUT_DOWNS, condition);

        List<CutDownInfo> cutDownInfos = jooq.selectFrom(GOODS_CUT_DOWNS)
                .where(condition)
                .offset(pageable.getOffset()).limit(pageable.getPageSize())
                .fetchInto(CutDownInfo.class);
        cutDownInfos.forEach(info -> {
            info.setDesc(info.getStatus());
            info.setLeftSecond(Duration.between(LocalDateTime.now(), info.getExpiryTimeAt()).getSeconds());
        });

        return new PageImpl<>(cutDownInfos, pageable, count);
    }
}
