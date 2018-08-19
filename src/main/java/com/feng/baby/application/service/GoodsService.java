package com.feng.baby.application.service;

import com.feng.baby.application.representation.*;
import com.feng.baby.support.utils.ResourceNotFoundException;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Result;
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


    public GoodsInfo goodsDetails(Integer id) {
        //查找主信息
        BasicInfo basicInfo = jooq.selectFrom(GOODS).where(GOODS.GOODS_ID.eq(id.toString())).fetchOptionalInto(BasicInfo.class).get();

        Result<Record1<Integer>> fetch = jooq.select(PROPERTIES.INDEXS).from(PROPERTIES).fetch();

        //查找类型信息
        Result<Record8<Integer, Integer, String, Integer, Integer, Integer, String, String>> result = jooq.select(
                PROPERTIES.ID,
                PROPERTIES.INDEXS,
                PROPERTIES.NAME,
                PROPERTIES_DETAIL.ID.as("detail_id"),
                PROPERTIES_DETAIL.PROPERTIES_ID.as("detail_properties_id"),
                PROPERTIES_DETAIL.INDEXS.as("detail_indexs"),
                PROPERTIES_DETAIL.NAME.as("detail_name"),
                PROPERTIES_DETAIL.REMARK.as("detail_remark"))
                .from(PROPERTIES)
                .innerJoin(PROPERTIES_DETAIL).on(PROPERTIES.ID.eq(PROPERTIES_DETAIL.PROPERTIES_ID))
                .fetch();

        Map<PropertiesRecord, Result<Record8<Integer, Integer, String, Integer, Integer, Integer, String, String>>> propertiesRecordResultMap = result.intoGroups(PROPERTIES);

        List<Properties> properties = propertiesRecordResultMap.entrySet().stream().map(record -> {
            Properties propertie = Properties.toProperties(record.getKey());
            propertie.setChildsCurGoods(
                    record.getValue().stream().map(value ->
                                 PropertiesDetail.builder()
                                        .id(value.value4())
                                        .propertiesId(value.value5())
                                        .indexs(value.value6())
                                        .name(value.value7())
                                        .remark(value.value8())
                                        .build()
                    ).collect(Collectors.toList())
            );
            return propertie;
        }).collect(Collectors.toList());

        //查找媒体信息
        List<GoodsMedia> goodsMedia = jooq.selectFrom(GOODS_MEDIA).where(GOODS_MEDIA.GOODS_ID.eq(id.toString())).fetchInto(GoodsMedia.class);

        return new GoodsInfo(basicInfo, properties, goodsMedia);
    }

    //检测商品是否是喜欢的
    public Map<String, Boolean> checkFav(String goodsId) {
        boolean isPresent = jooq.selectFrom(GOODS_FAV).where(GOODS_FAV.GOODS_ID.eq(goodsId)).fetchOptional().isPresent();
        return ImmutableMap.of("fav", isPresent);
    }

    public PintuanInfo pingtuanInfo(String goodsId) {
        return jooq.selectFrom(GOODS_PINTUAN)
                .where(GOODS_PINTUAN.GOODS_ID.eq(goodsId))
                .fetchOptionalInto(PintuanInfo.class).
                orElseThrow(ResourceNotFoundException::new);
    }

    public List<PintuanUsers> pingtuanList(String goodsId) {
        List<PintuanUsers> pintuanUsers = jooq.selectFrom(PINTUAN_USER)
                .where(PINTUAN_USER.GOODS_ID.eq(goodsId))
                .and(PINTUAN_USER.FINISHED.isFalse())
                .fetchInto(PintuanUsers.class);
        return pintuanUsers.isEmpty() ? null : pintuanUsers;
    }

    public Page<BasicInfo> topgoods(Pageable pageable) {
        int count = jooq.fetchCount(GOODS.leftJoin(GOODS_RECOMMEND).on(GOODS.GOODS_ID.eq(GOODS_RECOMMEND.GOODS_ID)));

        List<BasicInfo> basicInfos = jooq.selectFrom(GOODS.leftJoin(GOODS_RECOMMEND).on(GOODS.GOODS_ID.eq(GOODS_RECOMMEND.GOODS_ID)))
                .offset(pageable.getOffset()).limit(pageable.getPageSize())
                .fetchInto(BasicInfo.class);

        return new PageImpl<>(basicInfos, pageable, count);
    }

    public Page<BasicInfo> toptuan(Pageable pageable) {
        int count = jooq.fetchCount(GOODS.leftJoin(GOODS_PINTUAN).on(GOODS.GOODS_ID.eq(GOODS_PINTUAN.GOODS_ID)));

        List<BasicInfo> basicInfos = jooq.selectFrom(GOODS.leftJoin(GOODS_PINTUAN).on(GOODS.GOODS_ID.eq(GOODS_PINTUAN.GOODS_ID)))
                .offset(pageable.getOffset()).limit(pageable.getPageSize())
                .fetchInto(BasicInfo.class);

        return new PageImpl<>(basicInfos, pageable, count);
    }
}
