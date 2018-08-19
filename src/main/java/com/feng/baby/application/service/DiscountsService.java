package com.feng.baby.application.service;

import com.feng.baby.application.command.CouponsRepresentation;
import com.feng.baby.model.CouponsType;
import javafx.scene.SubScene;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public CouponsRepresentation availableNewCoupons(String openId) {

        //是否领取过新人红包
        Optional<CouponsRepresentation> couponsRepresentation = jooq.selectFrom(COUPONS_USERS.leftJoin(COUPONS).on(COUPONS_USERS.COUPON_ID.eq(COUPONS.COUPON_ID)))
                .where(COUPONS.TYPE.eq(CouponsType.WELCOME.name())).fetchOptionalInto(CouponsRepresentation.class);

       if(!couponsRepresentation.isPresent())
           return jooq.selectFrom(COUPONS)
                   .where(COUPONS.TYPE.eq(CouponsType.WELCOME.name()))
                   .fetchOptionalInto(CouponsRepresentation.class).get();


        List<String> couponids = jooq.selectFrom(COUPONS_USERS).where(COUPONS_USERS.USER_NAME.eq(openId)).fetch(COUPONS_USERS.COUPON_ID);

        List<CouponsRepresentation> couponsRepresentations = jooq.selectFrom(COUPONS)
                .where(
                        COUPONS.AVAILABLE.isTrue()
                                .and(COUPONS.PERIOD_OF_VALIDITY_TO_AT.gt(LocalDateTime.now()))
                                .and(COUPONS.COUPON_ID.notIn(couponids))
                ).fetchInto(CouponsRepresentation.class);

        return couponsRepresentations.stream().findFirst().orElse(null);
    }

    public void fetchCoupon(String openId, String couponId) {
        jooq.insertInto(COUPONS_USERS, COUPONS_USERS.USER_NAME, COUPONS_USERS.COUPON_ID)
                .values(openId, couponId)
                .onDuplicateKeyIgnore()
                .execute();
    }
}
