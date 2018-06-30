package com.feng.baby.adapter.controller;

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
    @GetMapping("/list")
    public String list(@RequestParam String type){
        return "{\"code\":0,\"data\":{\"creatAt\":\"2018-01-23 08:19:23\",\"dateType\":0,\"dateUpdate\":\"2018-05-12 18:40:15\",\"id\":2014,\"key\":\"mallName\",\"remark\":\"\",\"updateAt\":\"2018-01-23 08:19:23\",\"userId\":797,\"value\":\"清欢严选\"},\"msg\":\"success\"}";
    }

}
