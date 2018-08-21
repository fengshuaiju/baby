package com.feng.baby.adapter.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.feng.baby.application.representation.CmsRepresentation;
import com.feng.baby.application.service.CmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fengshuaiju on 2018-06-29.
 */
@Slf4j
@RestController
@RequestMapping("/cms")
public class CmsController {

    @Autowired
    private CmsService cmsService;

    @GetMapping("/category/list")
    public JSON categoryList(){
        return JSONObject.parseArray("[{\"dateAdd\":\"2018-03-02 18:47:33\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/03/07/f62ae7a5ec69f040f801cf6ad81627f2.png\",\"id\":1561,\"isUse\":true,\"key\":\"1\",\"level\":1,\"name\":\"严选推荐\",\"paixu\":1,\"pid\":0,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-03-10 23:08:20\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/03/07/5f08c595d1d60961fecf4e68044272b4.png\",\"id\":1587,\"isUse\":true,\"key\":\"2\",\"level\":1,\"name\":\"口碑商品\",\"paixu\":2,\"pid\":0,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-03-10 23:08:58\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/03/07/31a97db0b0db6dfdf2194375b6ce4115.png\",\"id\":1588,\"isUse\":true,\"key\":\"3\",\"level\":1,\"name\":\"特色系列\",\"paixu\":3,\"pid\":0,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-03-10 23:09:49\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/03/07/eff6f231c0911442a2836f7f2c892a18.png\",\"id\":1590,\"isUse\":true,\"key\":\"4\",\"level\":1,\"name\":\"严选LOOK\",\"paixu\":4,\"pid\":0,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-03-10 23:09:19\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/03/07/3ecd2f56395017129a0990640e18457f.png\",\"id\":1589,\"isUse\":true,\"key\":\"5\",\"level\":1,\"name\":\"十点一刻\",\"paixu\":5,\"pid\":0,\"type\":\"\",\"userId\":797}]");
    }

    @GetMapping("/detail")
    public CmsRepresentation detail(@RequestParam(required = false) String cmsId){
       return cmsService.detail(cmsId);
    }

}
