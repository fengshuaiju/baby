package com.feng.baby.adapter.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
    public JSONObject getValue(@RequestParam String key){

        if("mallName".equals(key)){
            return JSON.parseObject("{\"code\":0,\"data\":{\"creatAt\":\"2018-01-23 08:19:23\",\"dateType\":0,\"dateUpdate\":\"2018-05-12 18:40:15\",\"id\":2014,\"key\":\"mallName\",\"remark\":\"\",\"updateAt\":\"2018-01-23 08:19:23\",\"userId\":797,\"value\":\"清欢严选\"},\"msg\":\"success\"}");
        }else if("recharge_amount_min".equals(key)){
            return JSON.parseObject("{\"code\":404,\"msg\":\"暂无数据\"}");
        }
        return null;
    }

}
