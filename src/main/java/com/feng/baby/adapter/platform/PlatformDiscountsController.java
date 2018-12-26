package com.feng.baby.adapter.platform;

import com.feng.baby.application.command.Coupons;
import com.feng.baby.application.service.DiscountsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by fengshuaiju on 2018-06-29.
 */
@Slf4j
@RestController
@RequestMapping("/platform/discounts")
public class PlatformDiscountsController {

    private final DiscountsService discountsService;

    @Autowired
    public PlatformDiscountsController(DiscountsService discountsService) {
        this.discountsService = discountsService;
    }

    //获取创建的红包
    @GetMapping("/available")
    @PreAuthorize("#oauth2.hasAnyScope('user') and isAuthenticated()")
    public Page<Coupons> available(@RequestParam(defaultValue = "true") Boolean showAll, Pageable pageable){
        return discountsService.getAllCoupons(showAll, pageable);
    }

}
