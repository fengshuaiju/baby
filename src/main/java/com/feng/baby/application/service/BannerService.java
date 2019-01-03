package com.feng.baby.application.service;

import com.feng.baby.application.representation.FunctionMenus;
import com.feng.baby.application.representation.SlideContainer;
import com.feng.baby.model.SlideContainerType;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static sprout.jooq.generate.Tables.FUNCTION_MENUS;
import static sprout.jooq.generate.Tables.GOODS;
import static sprout.jooq.generate.Tables.SLIDE_CONTAINER;

@Service
public class BannerService {

    private final DSLContext jooq;

    @Autowired
    BannerService(DSLContext jooq) {
        this.jooq = jooq;
    }

    public List<SlideContainer> slideContainer(SlideContainerType type) {
        Condition condition = SLIDE_CONTAINER.IS_REMOVE.isFalse();
        if (type != null) {
            condition = condition.and(SLIDE_CONTAINER.TYPE.eq(type.name()));
        }

        return jooq.select(SLIDE_CONTAINER.ID,
                SLIDE_CONTAINER.IS_REMOVE,
                SLIDE_CONTAINER.TYPE,
                SLIDE_CONTAINER.GOODS_ID,
                SLIDE_CONTAINER.INDEXS,
                SLIDE_CONTAINER.PIC_URL,
                SLIDE_CONTAINER.CREATED_AT,
                GOODS.NAME.as("goodsName")
        ).from(SLIDE_CONTAINER.leftJoin(GOODS).on(SLIDE_CONTAINER.GOODS_ID.eq(GOODS.GOODS_ID)))
                .where(condition)
                .fetchInto(SlideContainer.class);
    }

    public List<FunctionMenus> functionMenus() {
        return jooq.selectFrom(FUNCTION_MENUS).fetchInto(FunctionMenus.class);
    }

    @Transactional
    public void createBanner(String goodsId, Integer index, String picUrl, SlideContainerType type) {
        jooq.insertInto(SLIDE_CONTAINER)
                .set(SLIDE_CONTAINER.GOODS_ID, goodsId)
                .set(SLIDE_CONTAINER.INDEXS, index)
                .set(SLIDE_CONTAINER.IS_REMOVE, false)
                .set(SLIDE_CONTAINER.PIC_URL, picUrl)
                .set(SLIDE_CONTAINER.TYPE, type.name())
                .execute();
    }

    public void createSlideContainer(String goodsId, String slideType, String picUrl) {
        jooq.insertInto(SLIDE_CONTAINER)
                .set(SLIDE_CONTAINER.GOODS_ID, goodsId)
                .set(SLIDE_CONTAINER.PIC_URL, picUrl)
                .set(SLIDE_CONTAINER.TYPE, slideType)
                .set(SLIDE_CONTAINER.INDEXS, 1)
                .set(SLIDE_CONTAINER.IS_REMOVE, false)
                .execute();
    }
}
