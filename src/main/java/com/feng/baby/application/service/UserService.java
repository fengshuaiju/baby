package com.feng.baby.application.service;

import com.feng.baby.application.command.UserInfoUpdated;
import com.feng.baby.application.representation.UserAccountInfo;
import com.feng.baby.application.representation.UserInfo;
import com.feng.baby.support.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.LikeEscapeStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public Page<UserInfo> userList(String phone, String date, Pageable pageable) {

        phone = phone == null ? "" : phone;
        Condition condition = USER_INFO.CELLPHONE.like("%" + phone + "%");

        if(StringUtils.isNotBlank(date)){
            condition = condition.and(USER_INFO.CREATED_AT.between(LocalDate.parse(date).atStartOfDay(), LocalDate.parse(date).plusDays(1).atStartOfDay()));
        }

        int count = jooq.fetchCount(USER_INFO,condition);

        List<UserInfo> userInfos = jooq.selectFrom(USER_INFO)
                .where(condition)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchInto(UserInfo.class);
        userInfos.forEach(UserInfo::updateGender);

        return new PageImpl<>(userInfos, pageable, count);
    }
}
