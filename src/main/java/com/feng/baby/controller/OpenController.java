package com.feng.baby.controller;

import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by fengshuaiju on 2018-06-15.
 */
@Slf4j
@RestController
public class OpenController {

    @GetMapping("/check-token")
    public Map<String,Object> checkToken(){
        return ImmutableMap.of("code", 0, "msg", "ok");
    }

    @GetMapping("/open/info")
    public Map<String,Object> info(){
        return ImmutableMap.of("code", 0, "msg", "ok");
    }

}
