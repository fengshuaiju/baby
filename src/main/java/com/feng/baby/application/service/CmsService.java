package com.feng.baby.application.service;

import com.feng.baby.application.representation.CmsRepresentation;
import com.feng.baby.model.CmsType;
import com.feng.baby.support.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static sprout.jooq.generate.Tables.CMS;

@Slf4j
@Service
public class CmsService {


    private final DSLContext jooq;

    @Autowired
    CmsService(DSLContext jooq) {
        this.jooq = jooq;
    }

    public CmsRepresentation detail(String cmsId) {
        return jooq.selectFrom(CMS).where(CMS.CMS_ID.eq(cmsId)).fetchOptionalInto(CmsRepresentation.class)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public Page<CmsRepresentation> newsList(CmsType cmsType, Pageable pageable) {

        Condition condition = CMS.IS_RECOMMEND.isTrue();
        int count = jooq.fetchCount(CMS, condition);

        List<CmsRepresentation> cmsRepresentations = jooq.select(
                CMS.CMS_ID,
                CMS.PIC,
                CMS.TITLE,
                CMS.MIN_PRICE,
                CMS.DESCRIPT
        ).from(CMS).where(condition)
                .offset(pageable.getOffset()).limit(pageable.getPageSize())
                .fetchInto(CmsRepresentation.class);

        return new PageImpl<>(cmsRepresentations, pageable, count);
    }

    public void addNewCms(String author, String categoryId, String content, boolean recommend,
                          String describe, String indexs, String minPrice, String pic, String title) {

    }
}
