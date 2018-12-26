package com.feng.baby.adapter.controller;

import com.feng.baby.application.command.GoodsPutOnOffCommand;
import com.feng.baby.application.representation.BasicInfo;
import com.feng.baby.application.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/shop/goods/platform")
public class GoodsPlatformController {

    private final GoodsService goodsService;

    @Autowired
    public GoodsPlatformController(GoodsService goodsService){
        this.goodsService = goodsService;
    }


    @GetMapping("/search")
    public Page<BasicInfo> platformSearch(@RequestParam(required = false) String keyWord,
                                          @RequestParam(required = false) String categoryId,
                                          Pageable pageable) {
        return goodsService.platformSearch(keyWord, categoryId, pageable);
    }

    @PutMapping("/pull-on-off")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void pullOnOff(@RequestBody GoodsPutOnOffCommand command){
        goodsService.pullOnOff(command.getGoodsId(), command.getStatus());
    }

    @PutMapping("/pull-on-off-grouping")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void pullOnOffGrouping(@RequestBody GoodsPutOnOffCommand command){
        goodsService.pullOnOffGrouping(command.getGoodsId(), command.getGrouping());
    }

    @GetMapping
    public void getPrice(){

    }


}
