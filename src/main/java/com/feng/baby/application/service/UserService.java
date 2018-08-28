package com.feng.baby.application.service;


import com.feng.baby.application.representation.Address;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static sprout.jooq.generate.Tables.USER_ADDRESS;

@Slf4j
@Service
public class UserService {


    private final DSLContext jooq;

    @Autowired
    UserService(DSLContext jooq) {
        this.jooq = jooq;
    }



}
