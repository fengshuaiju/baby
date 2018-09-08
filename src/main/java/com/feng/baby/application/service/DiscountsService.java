package com.feng.baby.application.service;

import com.feng.baby.application.command.Coupons;
import com.feng.baby.application.representation.MyCoupon;
import com.feng.baby.model.CouponsType;
import com.feng.baby.support.utils.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sprout.jooq.generate.tables.records.CouponsRecord;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static sprout.jooq.generate.Tables.COUPONS;
import static sprout.jooq.generate.Tables.COUPONS_USERS;

@Slf4j
@Service
public class DiscountsService {

    private final DSLContext jooq;

    @Autowired
    DiscountsService(DSLContext jooq) {
        this.jooq = jooq;
    }


    public Coupons availableNewCoupons(String openId) {

        //是否领取过新人红包
        Optional<Coupons> couponsRepresentation = jooq.selectFrom(COUPONS_USERS.leftJoin(COUPONS).on(COUPONS_USERS.COUPON_ID.eq(COUPONS.COUPON_ID)))
                .where(COUPONS.TYPE.eq(CouponsType.WELCOME.name())).fetchOptionalInto(Coupons.class);

        if (!couponsRepresentation.isPresent())
            return jooq.selectFrom(COUPONS)
                    .where(COUPONS.TYPE.eq(CouponsType.WELCOME.name()))
                    .fetchOptionalInto(Coupons.class).get();


        List<String> couponids = jooq.selectFrom(COUPONS_USERS).where(COUPONS_USERS.USER_NAME.eq(openId)).fetch(COUPONS_USERS.COUPON_ID);

        List<Coupons> coupons = jooq.selectFrom(COUPONS)
                .where(
                        COUPONS.AVAILABLE.isTrue()
                                .and(COUPONS.EXPIRY_TIME_AT.gt(LocalDateTime.now()))
                                .and(COUPONS.COUPON_ID.notIn(couponids))
                ).fetchInto(Coupons.class);

        return coupons.stream().findFirst().orElse(null);
    }

    public void fetchCoupon(String username, String couponId) {
        //查找红包信息
        CouponsRecord couponsRecord = jooq.selectFrom(COUPONS)
                .where(COUPONS.COUPON_ID.eq(couponId))
                .and(COUPONS.EXPIRY_TIME_AT.gt(LocalDateTime.now()))
                .and(COUPONS.AVAILABLE.isTrue()).fetchOptionalInto(COUPONS)
                .orElseThrow(ResourceNotFoundException::new);

        jooq.insertInto(COUPONS_USERS, COUPONS_USERS.USER_NAME, COUPONS_USERS.COUPON_ID,
                COUPONS_USERS.USED, COUPONS_USERS.COUPON_NAME, COUPONS_USERS.PIC_URL,
                COUPONS_USERS.EXPIRY_TIME_AT, COUPONS_USERS.REMARKS, COUPONS_USERS.AMOUNT_OF_MONEY,
                COUPONS_USERS.REQUIREMENT_CONSUMPTION)
                .values(username, couponId, new Byte("0"), couponsRecord.getCouponName(), couponsRecord.getPicUrl(),
                        LocalDateTime.now().plusDays(couponsRecord.getValidityDay()), couponsRecord.getRemarks(),
                        couponsRecord.getAmountOfMoney(), couponsRecord.getRequirementConsumption())
                .onDuplicateKeyIgnore()
                .execute();
    }

    public List<MyCoupon> myCoupons(String username) {
        return jooq.selectFrom(COUPONS_USERS)
                .where(COUPONS_USERS.USER_NAME.eq(username))
                .and(COUPONS_USERS.EXPIRY_TIME_AT.gt(LocalDateTime.now()))
                .and(COUPONS_USERS.USED.isFalse())
                .fetchInto(MyCoupon.class);
    }

    public List<Coupons> available(String username) {
        return jooq.selectFrom(COUPONS)
                .where(COUPONS.COUPON_ID.notIn(
                        jooq.select(COUPONS_USERS.COUPON_ID).from(COUPONS_USERS).where(COUPONS_USERS.USER_NAME.eq(username))
                ))
                .and(COUPONS.EXPIRY_TIME_AT.gt(LocalDateTime.now()))
                .fetchInto(Coupons.class);
    }
}
