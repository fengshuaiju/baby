package com.feng.baby.application.service;

import com.feng.baby.application.representation.*;
import com.feng.baby.model.GoodPriceType;
import com.feng.baby.support.utils.ResourceNotFoundException;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.jooq.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sprout.jooq.generate.tables.records.PropertiesRecord;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static sprout.jooq.generate.Tables.*;

@Slf4j
@Service
public class GoodsService {

    private final DSLContext jooq;

    @Autowired
    GoodsService(DSLContext jooq) {
        this.jooq = jooq;
    }


    public GoodsInfo goodsDetails(String goodsId) {
        //查找主信息
        BasicInfo basicInfo = jooq.selectFrom(GOODS).where(GOODS.GOODS_ID.eq(goodsId)).fetchOptionalInto(BasicInfo.class)
                .orElseThrow(ResourceNotFoundException::new);

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

        List<BasicInfo> basicInfos = jooq.selectFrom(GOODS.leftJoin(GOODS_RECOMMEND).on(GOODS.GOODS_ID.eq(GOODS_RECOMMEND.GOODS_ID)))
                .offset(pageable.getOffset()).limit(pageable.getPageSize())
                .fetchInto(BasicInfo.class);

        return new PageImpl<>(basicInfos, pageable, count);
    }

    public Page<BasicInfo> toptuan(Pageable pageable) {
        int count = jooq.fetchCount(GOODS.leftJoin(GROUP_BOOKING).on(GOODS.GOODS_ID.eq(GROUP_BOOKING.GOODS_ID)));

        List<BasicInfo> basicInfos = jooq.selectFrom(GOODS.leftJoin(GROUP_BOOKING).on(GOODS.GOODS_ID.eq(GROUP_BOOKING.GOODS_ID)))
                .offset(pageable.getOffset()).limit(pageable.getPageSize())
                .fetchInto(BasicInfo.class);

        return new PageImpl<>(basicInfos, pageable, count);
    }

    public Page<BasicInfo> cutdown(Pageable pageable) {
        int count = jooq.fetchCount(GOODS.leftJoin(GOODS_CUT_DOWN_INFO).on(GOODS.GOODS_ID.eq(GOODS_CUT_DOWN_INFO.GOODS_ID)));

        List<BasicInfo> basicInfos = jooq.selectFrom(GOODS.leftJoin(GOODS_CUT_DOWN_INFO).on(GOODS.GOODS_ID.eq(GOODS_CUT_DOWN_INFO.GOODS_ID)))
                .offset(pageable.getOffset()).limit(pageable.getPageSize())
                .fetchInto(BasicInfo.class);

        return new PageImpl<>(basicInfos, pageable, count);
    }


    public Page<BasicInfo> similar(Integer categoryId, Pageable pageable) {

        Condition condition = GOODS.CATEGORY_ID.eq(categoryId);

        int count = jooq.fetchCount(GOODS.leftJoin(GOODS_CUT_DOWN_INFO).on(GOODS.GOODS_ID.eq(GOODS_CUT_DOWN_INFO.GOODS_ID)), condition);

        List<BasicInfo> basicInfos = jooq.selectFrom(GOODS.leftJoin(GOODS_CUT_DOWN_INFO).on(GOODS.GOODS_ID.eq(GOODS_CUT_DOWN_INFO.GOODS_ID)))
                .where(condition)
                .offset(pageable.getOffset()).limit(pageable.getPageSize())
                .fetchInto(BasicInfo.class);

        return new PageImpl<>(basicInfos, pageable, count);
    }

    public Map<String, Double> getPrice(String goodsId, String propertyChildIds, GoodPriceType shopType) {

        Double price = jooq.selectFrom(GOODS_PRICE)
                .where(GOODS_PRICE.GOODS_ID.eq(goodsId))
                .and(GOODS_PRICE.TYPE.like( "%" + shopType.name() + "%"))
                .and(GOODS_PRICE.PROPERTIES_JOINT.eq(propertyChildIds))
                .fetchOptional(GOODS_PRICE.PRICE).orElse(999.00);

        return ImmutableMap.of("price", price);
    }
}
