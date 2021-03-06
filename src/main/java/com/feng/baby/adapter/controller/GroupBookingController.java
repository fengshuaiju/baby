package com.feng.baby.adapter.controller;

import com.feng.baby.application.command.AddGroupCommand;
import com.feng.baby.application.command.OpenGroupBooking;
import com.feng.baby.application.representation.GroupBookingInfo;
import com.feng.baby.application.representation.GroupBookingJoiner;
import com.feng.baby.application.service.GroupBookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/group-booking")
public class GroupBookingController {

    private final GroupBookingService groupBookingService;

    @Autowired
    public GroupBookingController(GroupBookingService groupBookingService) {
        this.groupBookingService = groupBookingService;
    }

    //创建开团配置信息
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void newGroupProperties(@RequestBody AddGroupCommand command){
        groupBookingService.newGroupProperties(command.getGoodsId(), command.getNumberRequire(), command.getTimeoutHours());
    }

    //开团
    @PostMapping("/open")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> open(@RequestBody OpenGroupBooking openGroupBooking) {
        return groupBookingService.open(openGroupBooking.getGoodsId(), openGroupBooking.getUsername());
//        return "{\"code\":0,\"data\":{\"dateAdd\":\"2018-04-28 08:11:13\",\"dateEnd\":\"2018-04-29 08:11:14\",\"dateUpdate\":\"2018-04-28 08:11:13\",\"goodsId\":3938,\"helpNumber\":0,\"id\":1,\"groupId\":2,\"status\":0,\"statusStr\":\"进行中\"},\"msg\":\"success\"}";
    }

    //加入拼团
    @GetMapping("/join")
    public void join(@RequestParam int tuanId) {

    }

    //获取拼团信息
    @GetMapping("/info")
    public GroupBookingInfo groupBookingInfo(@RequestParam String goodsId) {
        return groupBookingService.groupBookingInfo(goodsId);
    }

    //某商品所有的进行中团购
    @GetMapping("/list")
    public List<GroupBookingJoiner> groupBookingList(@RequestParam String goodsId) {
        return groupBookingService.groupBookingList(goodsId);
    }

}
