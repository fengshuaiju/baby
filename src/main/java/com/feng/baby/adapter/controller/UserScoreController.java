package com.feng.baby.adapter.controller;

import com.feng.baby.application.service.UserScoreService;
import com.feng.baby.model.SignRule;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    private final UserScoreService userScoreService;

    @Autowired
    public UserScoreController(UserScoreService userScoreService) {
        this.userScoreService = userScoreService;
    }

    //今日是否签到
    @GetMapping("/today-signed")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("#oauth2.hasAnyScope('user') and isAuthenticated()")
    public Map<String, Object> todaySigned(@AuthenticationPrincipal(expression = "username") String username) {
        return userScoreService.todaySigned(username);
    }

    //签到
    @GetMapping("/sign")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("#oauth2.hasAnyScope('user') and isAuthenticated()")
    public Map<String, Object> sign(@AuthenticationPrincipal(expression = "username") String username) {
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
