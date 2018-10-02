package com.feng.baby.application.service;

import com.feng.baby.application.command.UserInfoUpdated;
import com.feng.baby.application.representation.UserAccountInfo;
import com.feng.baby.application.representation.UserInfo;
import com.feng.baby.support.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static sprout.jooq.generate.Tables.USER_ACCOUNT;
import static sprout.jooq.generate.Tables.USER_INFO;

@Slf4j
@Service
public class UserService {

    private final DSLContext jooq;

    @Autowired
    UserService(DSLContext jooq) {
        this.jooq = jooq;
    }


    public UserAccountInfo getAccount(String username) {
        return jooq.selectFrom(USER_ACCOUNT).where(USER_ACCOUNT.USERNAME.eq(username))
                .fetchOptionalInto(UserAccountInfo.class).orElseThrow(ResourceNotFoundException::new);
    }

    @Transactional
    public void updateUserInfo(UserInfoUpdated userInfoUpdated) {
        jooq.selectFrom(USER_INFO).where(USER_INFO.USER_NAME.eq(userInfoUpdated.getUsername()))
                .fetchOptional().ifPresent(user -> {
            user.setNickName(userInfoUpdated.getNickName());
            user.setAvatarUrl(userInfoUpdated.getAvatarUrl());
            user.setGender(userInfoUpdated.getGender());
            user.setProvince(userInfoUpdated.getProvince());
            user.setCity(userInfoUpdated.getCity());
            user.setCountry(userInfoUpdated.getCountry());
            user.update();
        });
    }

    public Page<UserInfo> userList(Pageable pageable) {
        int count = jooq.fetchCount(USER_INFO);

        List<UserInfo> userInfos = jooq.selectFrom(USER_INFO)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchInto(UserInfo.class);

        return new PageImpl<>(userInfos, pageable, count);
    }
}
