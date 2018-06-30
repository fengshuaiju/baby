package com.feng.baby.adapter.controller;

import lombok.extern.slf4j.Slf4j;
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

    //检索可领取优惠券
    //参数名	数据类型	备注	必填
    //type	String	优惠券类型	X
    //refId	int	优惠券使用对象	X
    @GetMapping("/coupons")
    public String coupons(@RequestParam(required = false) String type,
                        @RequestParam(required = false) int refId){
        return "{\"code\":0,\"data\":[{\"dateAdd\":\"2017-08-16 11:14:58\",\"dateEndDays\":10,\"dateEndType\":1,\"dateStartType\":1,\"id\":5,\"moneyHreshold\":20,\"moneyMax\":10,\"moneyMin\":10,\"name\":\"万圣节大优惠\",\"numberGit\":0,\"numberGitNumber\":0,\"numberLeft\":0,\"numberPersonMax\":1,\"numberTotle\":999999,\"numberUsed\":0,\"status\":0,\"statusStr\":\"正常\",\"type\":\"shop\"},{\"dateAdd\":\"2017-08-16 11:14:16\",\"dateEndDays\":10,\"dateEndType\":1,\"dateStartType\":1,\"id\":4,\"moneyHreshold\":500,\"moneyMax\":60,\"moneyMin\":1,\"name\":\"再来一波\",\"numberGit\":0,\"numberGitNumber\":0,\"numberLeft\":0,\"numberPersonMax\":1,\"numberTotle\":999999,\"numberUsed\":0,\"status\":0,\"statusStr\":\"正常\",\"type\":\"shop\"},{\"dateAdd\":\"2017-08-16 11:13:42\",\"dateEndDays\":10,\"dateEndType\":1,\"dateStartType\":1,\"id\":3,\"moneyHreshold\":200,\"moneyMax\":50,\"moneyMin\":1,\"name\":\"全站通用\",\"numberGit\":0,\"numberGitNumber\":0,\"numberLeft\":0,\"numberPersonMax\":5,\"numberTotle\":999999,\"numberUsed\":0,\"status\":0,\"statusStr\":\"正常\",\"type\":\"shop\"}],\"msg\":\"success\"}";
    }

    //领取优惠券
    //参数名	数据类型	备注	必填
    //id	int	优惠券ID	Y
    //pwd	String	口令红包必须传	X
    //token	String	调用登录接口获取的登录凭证	Y
    //detect	String	如果传了该参数，并且是 true ，则不获取优惠券，而是检测当前用户是否可以获取	X
    @GetMapping("/fetch")
    public String fetch(@RequestParam int id,
                        @RequestParam(required = false) String pwd,
                        @RequestParam(required = false) String detect){
        return "{\"code\":0,\"data\":{\"dateEnd\":\"2017-08-27 00:00:00\",\"dateStart\":\"2017-08-16 13:46:47\",\"id\":1,\"money\":10,\"moneyHreshold\":20,\"name\":\"万圣节大优惠\",\"pid\":5,\"type\":\"shop\"},\"msg\":\"success\"}";
    }

    //我的优惠券
    //参数名	数据类型	备注	必填
    //token	String	调用登录接口返回的登录凭证	Y
    //status	int	优惠券状态	X
    @GetMapping("/my")
    public void my(){
        //TODO
    }



}
