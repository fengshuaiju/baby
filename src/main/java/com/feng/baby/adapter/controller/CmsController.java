package com.feng.baby.adapter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fengshuaiju on 2018-06-29.
 */
@Slf4j
@RestController
@RequestMapping("/cms")
public class CmsController {

    @GetMapping("/category/list")
    public void categoryList(){

    }

    @GetMapping("/news/detail")
    public void newsDetail(){

    }

    @GetMapping("/news/list")
    public void newsList(){

    }

}
