package com.feng.baby.adapter.controller;

import com.feng.baby.model.event.GoodsSaled;
import com.feng.baby.support.domain.DomainEventPublisher;
import com.feng.baby.support.utils.UploadFile;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/**
 * Created by fengshuaiju on 2018-06-15.
 */
@Slf4j
@RestController
public class OpenController {

    @GetMapping("/open/info")
    public Map<String,Object> info(){
        DomainEventPublisher.publish(GoodsSaled.builder().code("code").name("name").build());
        return ImmutableMap.of("code", 0, "msg", "ok");
    }

    @PostMapping("/open/file")
    public void file(@RequestParam("file") MultipartFile file) throws IOException {
        if(file.isEmpty()){
            return ;
        }
        File destFile = UploadFile.transToFile(file);
        UploadFile.uploadFile(destFile);
    }

}
