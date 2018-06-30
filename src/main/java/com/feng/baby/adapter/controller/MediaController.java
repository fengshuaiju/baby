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
@RequestMapping
public class MediaController {

    @GetMapping("/media/video/detail")
    public void detail(){

    }

    @GetMapping("/pay/wxapp/get-pay-data")
    public void getPayData(){

    }

    @GetMapping("/qrcode/wxa/unlimit")
    public void unlimit(){

    }


}
