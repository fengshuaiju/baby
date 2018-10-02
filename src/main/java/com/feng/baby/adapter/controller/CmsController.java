package com.feng.baby.adapter.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.feng.baby.application.command.AddCmsCommand;
import com.feng.baby.application.representation.CmsRepresentation;
import com.feng.baby.application.service.CmsService;
import com.feng.baby.model.CmsType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by fengshuaiju on 2018-06-29.
 */
@Slf4j
@RestController
@RequestMapping("/cms")
public class CmsController {

    private final CmsService cmsService;

    @Autowired
    public CmsController(CmsService cmsService) {
        this.cmsService = cmsService;
    }

    @GetMapping("/category/list")
    @ResponseStatus(HttpStatus.OK)
    public JSON categoryList(){
        return JSONObject.parseArray("[{\"dateAdd\":\"2018-03-02 18:47:33\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/03/07/f62ae7a5ec69f040f801cf6ad81627f2.png\",\"id\":1561,\"isUse\":true,\"key\":\"1\",\"level\":1,\"name\":\"严选推荐\",\"paixu\":1,\"pid\":0,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-03-10 23:08:20\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/03/07/5f08c595d1d60961fecf4e68044272b4.png\",\"id\":1587,\"isUse\":true,\"key\":\"2\",\"level\":1,\"name\":\"口碑商品\",\"paixu\":2,\"pid\":0,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-03-10 23:08:58\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/03/07/31a97db0b0db6dfdf2194375b6ce4115.png\",\"id\":1588,\"isUse\":true,\"key\":\"3\",\"level\":1,\"name\":\"特色系列\",\"paixu\":3,\"pid\":0,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-03-10 23:09:49\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/03/07/eff6f231c0911442a2836f7f2c892a18.png\",\"id\":1590,\"isUse\":true,\"key\":\"4\",\"level\":1,\"name\":\"严选LOOK\",\"paixu\":4,\"pid\":0,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-03-10 23:09:19\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/03/07/3ecd2f56395017129a0990640e18457f.png\",\"id\":1589,\"isUse\":true,\"key\":\"5\",\"level\":1,\"name\":\"十点一刻\",\"paixu\":5,\"pid\":0,\"type\":\"\",\"userId\":797}]");
    }

    @GetMapping("/detail")
    @ResponseStatus(HttpStatus.OK)
    public CmsRepresentation detail(@RequestParam(required = false) String cmsId){
       return cmsService.detail(cmsId);
    }

    @GetMapping("/news/list")
    @ResponseStatus(HttpStatus.OK)
    public Page<CmsRepresentation> newsList(@RequestParam(required = false) CmsType cmsType, Pageable pageable){
        return cmsService.newsList(cmsType, pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewCms(@RequestBody AddCmsCommand command){
        cmsService.addNewCms(command.getAuthor(), command.getCategoryId(), command.getContent(), command.isRecommend(),
                command.getDescribe(), command.getIndexs(), command.getMinPrice(), command.getPic(), command.getTitle());
    }
}
