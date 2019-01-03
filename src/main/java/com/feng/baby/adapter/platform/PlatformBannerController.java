package com.feng.baby.adapter.platform;

import com.feng.baby.application.command.AddSlideContainerCommand;
import com.feng.baby.application.representation.SlideContainer;
import com.feng.baby.application.service.BannerService;
import com.feng.baby.model.SlideContainerType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/platform/banner")
public class PlatformBannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SlideContainer> slideContainer(@RequestParam(required = false) SlideContainerType type){
        return bannerService.slideContainer(type);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSlideContainer(@RequestBody AddSlideContainerCommand command){
        bannerService.createSlideContainer(command.getGoodsId(), command.getSlideType(), command.getPicUrl());
    }

}
