package com.feng.baby.application.service;

import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ConfigureService {


    public Map<String, String> starterPage() {
        return ImmutableMap.of(
            "businessId", "30164",
            "picUrl", "https://cdn.it120.cc/apifactory/2018/05/19/4e72a11f1b291f4cacd72262ca6e96f0.png",
            "remark", "丸子君原创作品",
            "title", "清欢严选"
        );
    }
}
