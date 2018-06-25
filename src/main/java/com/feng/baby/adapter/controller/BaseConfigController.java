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
@RequestMapping("/open/base/config")
public class BaseConfigController {

    //获取基础配置数据
    @GetMapping
    public String mallName(@RequestParam String key){
        //获取商城名称
        if("mallName".equals(key)){
            return "{\"code\":0,\"data\":{\"creatAt\":\"2017-09-12 08:06:55\",\"dateType\":0,\"id\":612,\"key\":\"mallName\",\"remark\":\"笑笑服饰\",\"updateAt\":\"2017-09-12 08:06:55\",\"userId\":951,\"value\":\"天使童装\"},\"msg\":\"success\"}";
        }
        //获取最少充值金额
        if("recharge_amount_min".equals(key)){
            return "{\"code\":0,\"data\":{\"creatAt\":\"2018-01-22 07:39:05\",\"dateType\":0,\"id\":1984,\"key\":\"recharge_amount_min\",\"remark\":\"充值最少金额\",\"updateAt\":\"2018-01-22 07:39:05\",\"userId\":951,\"value\":\"1\"},\"msg\":\"success\"}";
        }

        return null;
    }


    //好评送积分规则
    @GetMapping("/reward/good-reputation")
    public String rewardOfGoodReputation(){
        return "{\"code\":0,\"data\":[{\"code\":\"goodReputation\",\"codeStr\":\"好评送\",\"confine\":0,\"score\":3}],\"msg\":\"success\"}";
    }


}
