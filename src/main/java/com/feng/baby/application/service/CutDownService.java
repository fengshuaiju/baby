package com.feng.baby.application.service;

import com.feng.baby.application.representation.CutDownInfo;
import com.feng.baby.application.representation.GoodsCutDownHelper;
import com.feng.baby.application.representation.UserInfo;
import com.feng.baby.support.utils.ResourceNotFoundException;
import com.feng.baby.support.utils.Validate;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sprout.jooq.generate.tables.records.GoodsCutDownInfoRecord;
import sprout.jooq.generate.tables.records.GoodsCutDownsRecord;
import sprout.jooq.generate.tables.records.GoodsRecord;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static sprout.jooq.generate.Tables.*;

@Slf4j
@Service
public class CutDownService {

    @Autowired
    private AccountService accountService;


    @Autowired
    CutDownService(DSLContext jooq) {
        this.jooq = jooq;
    }

    private final DSLContext jooq;


    public Map<String, Object> establishCutDown(String goodsId, String username) {
        //查找砍价配置信息 goods_cut_down;
        //验证该商品是可以砍价的商品
        GoodsCutDownInfoRecord goodsCutDownInfo = jooq.selectFrom(GOODS_CUT_DOWN_INFO)
                .where(GOODS_CUT_DOWN_INFO.GOODS_ID.eq(goodsId))
                .fetchOptionalInto(GOODS_CUT_DOWN_INFO)
                .orElseThrow(ResourceNotFoundException::new);

        //检验砍价表中是否已存在该用户发起的该商品的砍价
        String isExistCutDownId = jooq.selectFrom(GOODS_CUT_DOWNS)
                .where(GOODS_CUT_DOWNS.GOODS_ID.eq(goodsId)).and(GOODS_CUT_DOWNS.INITIATOR.eq(username))
                .fetchOptional(GOODS_CUT_DOWNS.CUT_DOWN_ID).orElse(null);
        if (isExistCutDownId != null) {
            return ImmutableMap.of("cutDownId", isExistCutDownId, "isNew", false);
        }


        //查询商品信息
        GoodsRecord goodsRecord = jooq.selectFrom(GOODS).where(GOODS.GOODS_ID.eq(goodsId))
                .fetchOptionalInto(GOODS).orElseThrow(ResourceNotFoundException::new);

        //向砍价表中增加信息
        String cutDownsId = UUID.randomUUID().toString();
        jooq.insertInto(GOODS_CUT_DOWNS).set(GOODS_CUT_DOWNS.GOODS_ID, goodsId)
                .set(GOODS_CUT_DOWNS.GOODS_PIC, goodsRecord.getMainPic())
                .set(GOODS_CUT_DOWNS.GOODS_NAME, goodsRecord.getName())
                .set(GOODS_CUT_DOWNS.CUT_DOWN_ID, cutDownsId)
                .set(GOODS_CUT_DOWNS.INITIATOR, username)
                .set(GOODS_CUT_DOWNS.CURRENT_PRICE, goodsRecord.getMinPrice())
                .set(GOODS_CUT_DOWNS.ORIGINAL_PRICE, goodsRecord.getMinPrice())
                .set(GOODS_CUT_DOWNS.BASE_PRICE, goodsRecord.getMinPrice() - goodsCutDownInfo.getMaxCutDown())
                .set(GOODS_CUT_DOWNS.CUT_TOTAL_AMOUNT, 0.0)
                .set(GOODS_CUT_DOWNS.HELPER_NUMBER, 0)
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
                .and(GOODS_CUT_DOWNS.FINISHED.isFalse())
                .fetchOptionalInto(GOODS_CUT_DOWNS)
                .orElseThrow(ResourceNotFoundException::new);
        //已经砍掉的金额
        Double cutTotalAmount = goodsCutDown.getCutTotalAmount();
        //能够砍掉的最大金额
        Double canMaxCutDown = goodsCutDownInfo.getMaxCutDown();


        //如果已砍金额超过可砍金额，报错
        if (cutTotalAmount >= canMaxCutDown) {
            jooq.update(GOODS_CUT_DOWNS).set(GOODS_CUT_DOWNS.FINISHED, Byte.valueOf("1")).execute();
            throw new IllegalStateException("goods cut downs already finished");
        }

        //TODO 要不要加上砍价人数的限制，如果人数达到，则不能再进行砍价

        //取出砍价的上下限,生成此次砍价的金额,并判定此次砍价后是否就结束砍价了
        Double maxAmountPerCut = goodsCutDownInfo.getMaxAmountPerCut();
        Double minAmountPerCut = goodsCutDownInfo.getMinAmountPerCut();

        double currentCutDown = new BigDecimal
                (Math.random() * (maxAmountPerCut - minAmountPerCut) + minAmountPerCut)
                .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        if ((cutTotalAmount + currentCutDown) > canMaxCutDown) {
            currentCutDown = canMaxCutDown - currentCutDown;
            jooq.update(GOODS_CUT_DOWNS)
                    .set(GOODS_CUT_DOWNS.FINISHED, Byte.valueOf("1"))
                    .set(GOODS_CUT_DOWNS.HELPER_NUMBER, goodsCutDown.getHelperNumber() + 1)
                    .set(GOODS_CUT_DOWNS.CUT_TOTAL_AMOUNT, goodsCutDown.getCutTotalAmount() + currentCutDown)
                    .set(GOODS_CUT_DOWNS.CURRENT_PRICE, goodsCutDown.getOriginalPrice() - currentCutDown - goodsCutDown.getCutTotalAmount())
                    .execute();
        }

        //插入此次砍价的记录
        jooq.insertInto(GOODS_CUT_DOWN_HELPER)
                .set(GOODS_CUT_DOWN_HELPER.PARTICIPANT, participant)
                .set(GOODS_CUT_DOWN_HELPER.CUT_DOWN_PRICE, currentCutDown)
                .set(GOODS_CUT_DOWN_HELPER.CUT_DOWN_ID, cutDownId)
                .execute();

        jooq.update(GOODS_CUT_DOWNS)
                .set(GOODS_CUT_DOWNS.HELPER_NUMBER, goodsCutDown.getHelperNumber() + 1)
                .set(GOODS_CUT_DOWNS.CUT_TOTAL_AMOUNT, new BigDecimal(goodsCutDown.getCutTotalAmount() + currentCutDown)
                        .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue())
                .set(GOODS_CUT_DOWNS.CURRENT_PRICE, goodsCutDown.getOriginalPrice() - currentCutDown - goodsCutDown.getCutTotalAmount())
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
}
