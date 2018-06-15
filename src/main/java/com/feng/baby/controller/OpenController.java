package com.feng.baby.controller;

import com.google.common.collect.ImmutableMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by fengshuaiju on 2018-06-15.
 */
@RestController
@RequestMapping("/open")
public class OpenController {

    @GetMapping("/info")
    public Map<String,String> info(){
        return ImmutableMap.of("info","ok");
    }

}
