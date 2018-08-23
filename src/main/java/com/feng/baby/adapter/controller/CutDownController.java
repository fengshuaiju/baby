package com.feng.baby.adapter.controller;

import com.feng.baby.application.command.CreateCutDown;
import com.feng.baby.application.command.HelpCutDown;
import com.feng.baby.application.representation.CutDownInfo;
import com.feng.baby.application.representation.GoodsCutDownHelper;
import com.feng.baby.application.service.CutDownService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    //砍价详情
    //我发起的砍价
    //发起一个砍价
    //砍价最后的底价是多少就可以获得商品了  0元获得  30元获得等

    //加入砍价
    //参数名	数据类型	备注	必填
    //kjid	int	砍价设置ID	Y
    //token	String	登录接口返回的登录凭证	Y
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> kanjiaJoin(@RequestBody CreateCutDown createCutDown) {
        return cutDownService.establishCutDown(createCutDown.getGoodsId(), createCutDown.getUsername());
//        return "{\"code\":0,\"data\":{\"curPrice\":3,\"dateAdd\":\"2018-04-01 08:47:29\",\"dateUpdate\":\"2018-04-01 08:47:29\",\"goodsId\":1,\"helpNumber\":0,\"kjId\":2,\"minPrice\":4,\"status\":0},\"msg\":\"success\"}";
    }

    //获取已被砍信息，砍价发起者，砍价过期时间等
    @GetMapping("/info")
    public CutDownInfo getCutDownInfo(@RequestParam String cutDownId){
        return cutDownService.getCutDownInfo(cutDownId);
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
