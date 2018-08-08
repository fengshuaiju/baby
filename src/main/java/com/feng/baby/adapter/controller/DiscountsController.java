package com.feng.baby.adapter.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
    public JSON coupons(@RequestParam(required = false) String type,
                        @RequestParam(required = false) Integer refId) {
        if ("shop".equals(type)) {
            return JSONObject.parseArray("[{\"dateAdd\":\"2018-03-12 20:54:24\",\"dateEndDays\":10,\"dateEndType\":1,\"dateStartType\":1,\"dateUpdate\":\"2018-08-08 10:56:42\",\"id\":1409,\"moneyHreshold\":288,\"moneyMax\":5,\"moneyMin\":5,\"name\":\"上面口令输入 666  \",\"needScore\":0,\"needSignedContinuous\":0,\"numberGit\":1062,\"numberGitNumber\":650,\"numberLeft\":38,\"numberPersonMax\":3,\"numberTotle\":327,\"numberUsed\":22,\"refId\":30164,\"status\":0,\"statusStr\":\"正常\",\"type\":\"shop\"},{\"dateAdd\":\"2018-03-12 20:53:22\",\"dateEndDays\":10,\"dateEndType\":1,\"dateStartType\":1,\"dateUpdate\":\"2018-08-08 10:15:28\",\"id\":1408,\"moneyHreshold\":99,\"moneyMax\":10,\"moneyMin\":10,\"name\":\"20积分兑换超值礼券\",\"needScore\":20,\"needSignedContinuous\":0,\"numberGit\":479,\"numberGitNumber\":479,\"numberLeft\":589,\"numberPersonMax\":2,\"numberTotle\":1000,\"numberUsed\":15,\"status\":0,\"statusStr\":\"正常\",\"type\":\"shop\"}]");
        }

        return null;
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
                        @RequestParam(required = false) String detect) {
        return "{\"code\":0,\"data\":{\"dateEnd\":\"2017-08-27 00:00:00\",\"dateStart\":\"2017-08-16 13:46:47\",\"id\":1,\"money\":10,\"moneyHreshold\":20,\"name\":\"万圣节大优惠\",\"pid\":5,\"type\":\"shop\"},\"msg\":\"success\"}";
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
