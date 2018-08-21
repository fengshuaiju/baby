package com.feng.baby.application.service;

import com.feng.baby.application.representation.FunctionMenus;
import com.feng.baby.application.representation.SlideContainer;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static sprout.jooq.generate.Tables.FUNCTION_MENUS;
import static sprout.jooq.generate.Tables.SLIDE_CONTAINER;

@Service
public class BannerService {

    private final DSLContext jooq;

    @Autowired
    BannerService(DSLContext jooq) {
        this.jooq = jooq;
    }

    public List<SlideContainer> slideContainer() {
        Condition condition = SLIDE_CONTAINER.STATUS.isTrue();
        return jooq.selectFrom(SLIDE_CONTAINER)
                .where(condition).fetchInto(SlideContainer.class);
    }

    public List<FunctionMenus> functionMenus() {
        return jooq.selectFrom(FUNCTION_MENUS).fetchInto(FunctionMenus.class);
    }
}
