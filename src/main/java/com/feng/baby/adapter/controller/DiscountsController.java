package com.feng.baby.adapter.controller;

import com.feng.baby.application.service.DiscountsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    //参数名	数据类型	备注	必填
    //id	int	优惠券ID	Y
    //pwd	String	口令红包必须传	X
    //token	String	调用登录接口获取的登录凭证	Y
    //detect	String	如果传了该参数，并且是 true ，则不获取优惠券，而是检测当前用户是否可以获取	X
    @GetMapping("/fetch")
    public void fetch(@RequestParam String openId,
                        @RequestParam String couponId) {
        discountsService.fetchCoupon(openId, couponId);
    }

    //我的优惠券
    //参数名	数据类型	备注	必填
    //token	String	调用登录接口返回的登录凭证	Y
    //status	int	优惠券状态	X
    @GetMapping("/my")
    public void my() {
        //TODO
    }


}
