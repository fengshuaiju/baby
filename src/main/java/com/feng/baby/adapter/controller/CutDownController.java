package com.feng.baby.adapter.controller;

import com.feng.baby.application.command.CreateCutDown;
import com.feng.baby.application.command.HelpCutDown;
import com.feng.baby.application.representation.BasicInfo;
import com.feng.baby.application.representation.CutDownInfo;
import com.feng.baby.application.representation.GoodsCutDownHelper;
import com.feng.baby.application.service.CutDownService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/cutdown")
public class CutDownController {

    @Autowired
    private CutDownService cutDownService;

    //砍价列表
    @GetMapping
    public Page<BasicInfo> cutdown(Pageable pageable){
        return cutDownService.cutdown(pageable);
    }


    //创建一个砍价
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> newCutDown(@RequestBody CreateCutDown createCutDown) {
        return cutDownService.newCutDown(createCutDown.getGoodsId(), createCutDown.getUsername(),
                createCutDown.getPropertyChildIds(), createCutDown.getGoodsLabel(), createCutDown.getBuyNumber());
    }

    @GetMapping("/list")
    public Page<CutDownInfo> myCutList(@RequestParam String username, Pageable pageable){
        return cutDownService.myCutList(username, pageable);
    }

    //获取已被砍信息，砍价发起者，砍价过期时间等
    @GetMapping("/info")
    public CutDownInfo getCutDownInfo(@RequestParam String cutDownId){
        return cutDownService.getCutDownInfo(cutDownId);
    }

    @GetMapping("/check-exist")
    public Map<String, Object> checkExist(@RequestParam String username, @RequestParam String goodsId){
        return cutDownService.checkExist(username, goodsId);
    }

    //获取已被砍信息，砍价发起者，砍价过期时间等
    @GetMapping("/my-help")
    public GoodsCutDownHelper getMyHelp(@RequestParam String cutDownId,
                                        @RequestParam String username){
        return cutDownService.getMyHelp(cutDownId, username);
    }

    @PostMapping("/help")
    @ResponseStatus(HttpStatus.CREATED)
    public GoodsCutDownHelper helpCutDown(@RequestBody HelpCutDown helpCutDown){
        cutDownService.helpCutDown(helpCutDown.getGoodsId(), helpCutDown.getCutDownId(), helpCutDown.getParticipant());
        return cutDownService.getMyHelp(helpCutDown.getCutDownId(), helpCutDown.getParticipant());
    }

    @GetMapping("/helpers")
    public List<GoodsCutDownHelper> getHelpers(@RequestParam String cutDownId){
        return cutDownService.getHelpers(cutDownId);
    }

}
