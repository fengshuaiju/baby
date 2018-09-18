package com.feng.baby.application.service;

import com.feng.baby.application.representation.GroupBookingInfo;
import com.feng.baby.application.representation.GroupBookingJoiner;
import com.feng.baby.model.GroupBookingStatus;
import com.feng.baby.support.utils.ResourceNotFoundException;
import com.feng.baby.support.utils.Validate;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.persister.walking.spi.CollectionElementDefinition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sprout.jooq.generate.tables.records.GroupBookingPropertiesRecord;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static sprout.jooq.generate.Tables.*;

@Slf4j
@Service
public class GroupBookingService {

    private final DSLContext jooq;

    @Autowired
    GroupBookingService(DSLContext jooq) {
        this.jooq = jooq;
    }


    public GroupBookingInfo groupBookingInfo(String goodsId) {
        return jooq.selectFrom(GROUP_BOOKING_PROPERTIES)
                .where(GROUP_BOOKING_PROPERTIES.GOODS_ID.eq(goodsId))
                .and(GROUP_BOOKING_PROPERTIES.IS_REMOVE.isTrue())
                .fetchOptionalInto(GroupBookingInfo.class).
                        orElseThrow(ResourceNotFoundException::new);
    }

    public List<GroupBookingJoiner> groupBookingList(String goodsId) {
        List<GroupBookingJoiner> groupBookingUsers = jooq.select(
                GROUP_BOOKING.GROUP_BOOKING_ID,
                GROUP_BOOKING.NUMBER_REQUIRE,
                GROUP_BOOKING.NUMBER_LEFT,
                GROUP_BOOKING.STATUS,
                USER_INFO.NICK_NAME,
                USER_INFO.AVATAR_URL,
                GROUP_BOOKING.EXPIRY_TIME_AT)
                .from(GROUP_BOOKING.leftJoin(GROUP_BOOKING_JOINER).on(GROUP_BOOKING.GROUP_BOOKING_ID.eq(GROUP_BOOKING.GROUP_BOOKING_ID))
                        .leftJoin(USER_INFO).on(GROUP_BOOKING_JOINER.USERNAME.eq(USER_INFO.USER_NAME)))
                .where(GROUP_BOOKING.GOODS_ID.eq(goodsId))
                .and(GROUP_BOOKING.STATUS.eq(GroupBookingStatus.IN_PROGRESS.name()))
                .fetchInto(GroupBookingJoiner.class);

        return groupBookingUsers.stream().map(GroupBookingJoiner::toLeftSecond).collect(Collectors.toList());
    }

    public Map<String, String> open(String goodsId, String username) {
        //检查该商品是否支持开团
        Boolean isSupportGrouping = jooq.select(GOODS.IS_SUPPORT_PINGTUAN).from(GOODS)
                .where(GOODS.GOODS_ID.eq(goodsId)).and(GOODS.IS_REMOVE.isTrue())
                .fetchOptionalInto(Boolean.TYPE)
                .orElseThrow(ResourceNotFoundException::new);

        Validate.isTrue(isSupportGrouping, "this goods is not support grouping");

        //查找商品开团配置信息
        GroupBookingPropertiesRecord groupBookingProperties = jooq.selectFrom(GROUP_BOOKING_PROPERTIES)
                .where(GROUP_BOOKING_PROPERTIES.GOODS_ID.eq(goodsId))
                .and(GROUP_BOOKING_PROPERTIES.IS_REMOVE.isTrue())
                .fetchOptionalInto(GROUP_BOOKING_PROPERTIES)
                .orElseThrow(ResourceNotFoundException::new);

        //创建开团信息
        String groupBookingId = UUID.randomUUID().toString();
        jooq.insertInto(GROUP_BOOKING)
                .set(GROUP_BOOKING.GOODS_ID, goodsId)
                .set(GROUP_BOOKING.CREATED_AT, LocalDateTime.now())
                .set(GROUP_BOOKING.EXPIRY_TIME_AT, LocalDateTime.now().minusHours(groupBookingProperties.getTimeoutHours()))
                .set(GROUP_BOOKING.GROUP_BOOKING_ID, groupBookingId)
                .set(GROUP_BOOKING.NUMBER_REQUIRE, groupBookingProperties.getNumberRequire())
                .set(GROUP_BOOKING.NUMBER_LEFT, groupBookingProperties.getNumberRequire())
                .set(GROUP_BOOKING.STATUS, GroupBookingStatus.INIT.name())
                .set(GROUP_BOOKING.OPENER, username)
                .execute();

        jooq.insertInto(GROUP_BOOKING_JOINER)
                .set(GROUP_BOOKING_JOINER.GOODS_ID, goodsId)
                .set(GROUP_BOOKING_JOINER.USERNAME, username)
                .set(GROUP_BOOKING_JOINER.GROUP_BOOKING_ID, groupBookingId)
                .execute();

        return ImmutableMap.of("groupBookingId", groupBookingId);

    }
}
