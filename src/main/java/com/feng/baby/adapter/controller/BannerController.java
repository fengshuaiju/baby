package com.feng.baby.adapter.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fengshuaiju on 2018-06-29.
 */
@Slf4j
@RestController
@RequestMapping("/banner")
public class BannerController {

    //App Banner管理接口
    //参数名	数据类型	备注	必填
    //type	String	Banner类型，后台自定义	X
    //key
    public JSONObject list(@RequestParam String type,
                           @RequestParam String key){
        return JSONObject.parseObject("{\"code\":0,\"data\":[{\"businessId\":30164,\"dateAdd\":\"2018-03-12 17:48:47\",\"dateUpdate\":\"2018-05-19 11:24:33\",\"id\":5581,\"linkUrl\":\"\",\"paixu\":0,\"picUrl\":\"https://cdn.it120.cc/apifactory/2018/05/19/4e72a11f1b291f4cacd72262ca6e96f0.png\",\"remark\":\"丸子君原创作品\",\"status\":0,\"statusStr\":\"显示\",\"title\":\"清欢严选\",\"type\":\"start\",\"userId\":797}],\"msg\":\"success\"}");
    }

}
