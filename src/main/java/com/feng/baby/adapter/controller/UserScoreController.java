package com.feng.baby.adapter.controller;

import com.feng.baby.application.service.UserScoreService;
import com.feng.baby.model.SignRule;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by fengshuaiju on 2018-06-29.
 */
@Slf4j
@RestController
@RequestMapping("/score")
public class UserScoreController {

    @Autowired
    private UserScoreService userScoreService;

    //今日是否签到
    @GetMapping("/today-signed")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> todaySigned(@RequestParam String username) {
        return userScoreService.todaySigned(username);
    }

    //签到
    @GetMapping("/sign")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> sign(@RequestParam String username) {
        return userScoreService.sign(username);
    }

    //获取签到赠送积分规则
    @GetMapping("/sign/rules")
    public List<ImmutableMap<String, Integer>> rules() {
        return SignRule.data.entrySet().stream().map(entry ->
                ImmutableMap.of("continuous", entry.getKey(), "score", entry.getValue())
        ).collect(Collectors.toList());
    }

}
