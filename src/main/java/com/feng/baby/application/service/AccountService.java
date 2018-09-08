package com.feng.baby.application.service;

import com.feng.baby.application.representation.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sprout.jooq.generate.tables.records.UserInfoRecord;

import static sprout.jooq.generate.Tables.USER_ACCOUNT;
import static sprout.jooq.generate.Tables.USER_INFO;

@Slf4j
@Service
public class AccountService {

    private final DSLContext jooq;

    @Autowired
    AccountService(DSLContext jooq){
        this.jooq = jooq;
    }

    @Transactional
    public void createAccount(String userName, String nickName) {

        //创建用户信息
        jooq.insertInto(USER_INFO).set(USER_INFO.USER_NAME, userName)
                .set(USER_INFO.NICK_NAME, nickName)
                .set(USER_INFO.WECHAT_OPEN_ID, userName)
                .execute();

        //创建用户账户信息
        jooq.insertInto(USER_ACCOUNT)
                .set(USER_ACCOUNT.USERNAME, userName)
                .set(USER_ACCOUNT.SCORE, 0)
                .set(USER_ACCOUNT.ACCOUNT, 0.0)
                .execute();
        log.info("create account success, userName :{}", userName);
    }

    public UserInfo getUserInfoByUserName(String username) {
        return jooq.selectFrom(USER_INFO).where(USER_INFO.USER_NAME.eq(username)).fetchOptionalInto(UserInfo.class).orElseThrow(IllegalArgumentException::new);
    }
}

