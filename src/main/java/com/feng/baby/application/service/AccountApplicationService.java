package com.feng.baby.application.service;

import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sprout.jooq.generate.tables.records.UserInfoRecord;

import static sprout.jooq.generate.Tables.USER_INFO;

@Slf4j
@Service
public class AccountApplicationService {

    private final DSLContext jooq;

    @Autowired
    AccountApplicationService(DSLContext jooq){
        this.jooq = jooq;
    }

    @Transactional
    public void createAccount(String userName, String nickName) {

        jooq.insertInto(USER_INFO).set(USER_INFO.USER_NAME, userName)
                .set(USER_INFO.NICK_NAME, nickName)
                .set(USER_INFO.WECHAT_OPEN_ID, userName)
                .execute();
        log.info("create account success, userName :{}", userName);
    }
}

