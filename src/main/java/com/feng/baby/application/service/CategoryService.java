package com.feng.baby.application.service;

import com.feng.baby.application.representation.Category;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static sprout.jooq.generate.tables.Category.CATEGORY;

@Slf4j
@Service
public class CategoryService {

    private final DSLContext jooq;

    @Autowired
    CategoryService(DSLContext jooq) {
        this.jooq = jooq;
    }


    public List<Category> allTypes() {
        return jooq.selectFrom(CATEGORY).where(CATEGORY.LEVEL.eq(2)).fetchInto(Category.class);
    }


    public void addCategory(String pid, String icon, Integer indexs, Integer level, String name) {

        jooq.insertInto(CATEGORY)
                .set(CATEGORY.PID, pid)
                .set(CATEGORY.ICON, icon)
                .set(CATEGORY.INDEXS, indexs)
                .set(CATEGORY.LEVEL, level)
                .set(CATEGORY.NAME, name)
                .set(CATEGORY.IS_USED, true)
                .set(CATEGORY.CATEGORY_ID, UUID.randomUUID().toString())
                .execute();

    }

    public List<Category> all() {
        return jooq.selectFrom(CATEGORY).fetchInto(Category.class);
    }
}
