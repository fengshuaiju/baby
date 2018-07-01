package com.feng.baby.adapter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fengshuaiju on 2018-06-23.
 */
@Slf4j
@RestController
@RequestMapping("/open/config")
public class ConfigController {

    @GetMapping("/get-value")
    public String getValue(@RequestParam String key){
        if("mallName".equals(key)){
            return "{\"code\":0,\"data\":{\"creatAt\":\"2017-01-16 12:09:31\",\"dateType\":0,\"id\":4,\"key\":\"test\",\"remark\":\"测试\",\"updateAt\":\"2017-01-16 12:09:31\",\"userId\":2,\"value\":\"sjkhdskjfhkjsdh\"},\"msg\":\"success\"}";
        }else if("recharge_amount_min".equals(key)){
            return "{\"code\":404,\"msg\":\"暂无数据\"}";
        }
        return null;
    }

}
