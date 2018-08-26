package com.feng.baby.adapter.controller;

import com.feng.baby.application.representation.MyCoupon;
import com.feng.baby.application.service.DiscountsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by fengshuaiju on 2018-06-29.
 */
@Slf4j
@RestController
@RequestMapping("/discounts")
public class DiscountsController {

    @Autowired
    private DiscountsService discountsService;

    //领取优惠券
    @GetMapping("/fetch")
    public void fetch(@RequestParam String openId, @RequestParam String couponId) {
        discountsService.fetchCoupon(openId, couponId);
    }

    //我的优惠券
    @GetMapping("/my")
    public List<MyCoupon> my(@RequestParam String username) {
        return discountsService.myCoupons(username);
    }

}
