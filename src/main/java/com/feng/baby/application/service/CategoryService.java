package com.feng.baby.application.service;

import com.feng.baby.application.representation.Category;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return jooq.selectFrom(CATEGORY).fetchInto(Category.class);
    }
}
