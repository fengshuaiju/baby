package com.feng.baby.adapter.controller;

import com.feng.baby.application.command.AddNewCouponCommand;
import com.feng.baby.application.command.Coupons;
import com.feng.baby.application.command.FetchCoupons;
import com.feng.baby.application.representation.MyCoupon;
import com.feng.baby.application.service.DiscountsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fengshuaiju on 2018-06-29.
 */
@Slf4j
@RestController
@RequestMapping("/discounts")
public class DiscountsController {

    private final DiscountsService discountsService;

    @Autowired
    public DiscountsController(DiscountsService discountsService) {
        this.discountsService = discountsService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addNewCoupon(@RequestBody AddNewCouponCommand command){
        discountsService.addNewCoupon(command.getPicUrl(), command.getLinkUrl(), command.getCouponName(),
                command.getType(), command.getAmountOfMoney(), command.getRequirementConsumption(),
                command.getValidityDay(), command.getRemarks());
    }

    @GetMapping("/newcoupons")
    public Coupons availableNewCoupons(@RequestParam String openId){
        return discountsService.availableNewCoupons(openId);
    }

    //领取优惠券
    @PostMapping("/fetch")
    @ResponseStatus(HttpStatus.CREATED)
    public void fetch(@RequestBody FetchCoupons fetchCoupons) {
        discountsService.fetchCoupon(fetchCoupons.getUsername(), fetchCoupons.getCouponId());
    }

    //我的优惠券
    @GetMapping("/my")
    @ResponseStatus(HttpStatus.OK)
    public List<MyCoupon> myCoupons(@RequestParam String username) {
        return discountsService.myCoupons(username);
    }

    //获取可以领取的红包
    @GetMapping("/available")
    public List<Coupons> available(@RequestParam String username){
        return discountsService.available(username);
    }

}
