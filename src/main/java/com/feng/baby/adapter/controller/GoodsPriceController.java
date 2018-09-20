package com.feng.baby.adapter.controller;

import com.feng.baby.application.service.GoodsPriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/shop/goods")
public class GoodsPriceController {

    private final GoodsPriceService goodsPriceService;

    @Autowired
    public GoodsPriceController(GoodsPriceService goodsPriceService) {
        this.goodsPriceService = goodsPriceService;
    }

    //选中商品类型后 计算价格
    @GetMapping("/price")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Double> price(@RequestParam String goodsId, @RequestParam String propertyChildIds) {
        propertyChildIds = Arrays.stream(propertyChildIds.split(":")).sorted(String::compareTo).collect(Collectors.joining(":"));
        return goodsPriceService.getPrice(goodsId, propertyChildIds);
    }

    //获取商品的价格信息，原价、砍价、团购价等信息
    @GetMapping("/price/info")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getGoodsPriceInfo(@RequestParam String goodsId){
        return goodsPriceService.getPriceInfo(goodsId);
    }


    //获取物流费用接口
    //参数名	数据类型	备注	必填
    //templateId	int	运费模板编号，可通过商品列表、商品详情接口获取	Y
    //type	int	快递方式：0 快递 1 EMS 2 平邮	Y
    //provinceId	int	用户省份编号	X
    //cityId	int	用户城市编号	X
    //districtId	int	用户区县编号	X
    @GetMapping("/price/freight")
    public String freight(@RequestParam int templateId,
                          @RequestParam int type,
                          @RequestParam(required = false) int provinceId,
                          @RequestParam(required = false) int cityId,
                          @RequestParam(required = false) int districtId) {
        return "{\"code\":0,\"data\":{\"firstNumber\":9,\"addAmount\":12,\"firstAmount\":10,\"addNumber\":11},\"msg\":\"success\"}";
    }

}
