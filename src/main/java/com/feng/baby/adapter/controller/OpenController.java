package com.feng.baby.adapter.controller;

import com.feng.baby.model.event.GoodsSailed;
import com.feng.baby.support.domain.DomainEventPublisher;
import com.feng.baby.support.utils.UploadFile;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by fengshuaiju on 2018-06-15.
 */
@Slf4j
@RestController
public class OpenController {

    @Value("${tencent.file.path}")
    private String basePath;

    @GetMapping("/open/info")
    public Map<String,Object> info(){
        DomainEventPublisher.publish(GoodsSailed.builder().code("code").name("name").build());
        return ImmutableMap.of("code", 0, "msg", "ok");
    }

    @PostMapping("/open/file")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> file(@RequestParam("file") MultipartFile file) throws IOException {
        if(file.isEmpty()){
            return null;
        }
        File destFile = UploadFile.transToFile(file);
        return ImmutableMap.of("basePath", basePath, "picUrl", UploadFile.uploadFile(destFile));
    }

}
