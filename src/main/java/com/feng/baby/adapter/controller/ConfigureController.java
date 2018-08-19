package com.feng.baby.adapter.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.feng.baby.application.service.ConfigureService;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by fengshuaiju on 2018-06-23.
 */
@Slf4j
@RestController
@RequestMapping("/open/config")
public class ConfigureController {

    @Autowired
    private ConfigureService configureService;

    @GetMapping("/get-value")
    @ResponseStatus(HttpStatus.OK)
    public JSONObject getValue(@RequestParam String key){

        if("recharge_amount_min".equals(key)){
            return JSON.parseObject("{\"code\":404,\"msg\":\"暂无数据\"}");
        }

        if("toptuan".equals(key)){
            return JSON.parseObject("{\"creatAt\":\"2018-05-10 22:58:11\",\"dateType\":0,\"dateUpdate\":\"2018-07-12 09:58:46\",\"id\":3685,\"key\":\"toptuan\",\"remark\":\"/pages/pingtuan-list/index\",\"updateAt\":\"2018-05-10 22:58:11\",\"userId\":797,\"value\":\"拼团特惠\"}");
        }

//        if("topgoods".equals(key)){
//            return JSONObject.parseObject("{\"creatAt\":\"2018-05-11 12:00:17\",\"dateType\":0,\"id\":3690,\"key\":\"topgoods\",\"remark\":\"/pages/index/index\",\"updateAt\":\"2018-05-11 12:00:17\",\"userId\":797,\"value\":\"人气推荐\"}");
//        }

        if("shopcart".equals(key)){
            return JSONObject.parseObject("{\"creatAt\":\"2018-05-12 18:40:01\",\"dateType\":0,\"dateUpdate\":\"2018-06-21 21:31:45\",\"id\":3705,\"key\":\"shopcart\",\"remark\":\"\",\"updateAt\":\"2018-05-12 18:40:01\",\"userId\":797,\"value\":\"30164,43223,40601,30164\"}");
        }

        if("mallinfo".equals(key)){
            return JSONObject.parseObject("{\"creatAt\":\"2018-05-09 10:19:07\",\"dateType\":0,\"dateUpdate\":\"2018-06-20 20:05:12\",\"id\":3636,\"key\":\"mallinfo\",\"remark\":\"\",\"updateAt\":\"2018-05-09 10:19:07\",\"userId\":797,\"value\":\"清欢严选 v2.1.0\"}");
        }

        return null;
    }

    @GetMapping("/starter")
    public Map<String, String> starterPage(){
        return configureService.starterPage();
    }


    @GetMapping("/mall-name")
    public Map<String, String> mallName(){
        return ImmutableMap.of("value", "帅帅小店");
    }

    //获取积分赠送规则
    @GetMapping("/send-score/rule")
    public Map<String, String> sendRule(@RequestParam String code){
        if("goodReputation".equals(code)){
            return ImmutableMap.of(
                "score", "5",
                "code", "goodReputation",
                "codeStr", "好评送",
                "confine", "1"
            );
        }else{
            return null;
        }
    }


    @GetMapping("/send-score/recharge-amount-min")
    public Map<String, String> rechargeAmountMin(){
        return ImmutableMap.of(
                "value", "0"
        );
    }

}
