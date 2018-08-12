package com.feng.baby.adapter.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fengshuaiju on 2018-06-29.
 */
@Slf4j
@RestController
@RequestMapping("/score")
public class ScoreController {

    //今日是否签到
    //参数名	数据类型	备注	必填
    //token	String	登录接口	Y
    @GetMapping("/today-signed")
    public String todaySigned(){
        return "{\"code\":0,\"data\":{\"continuous\":1,\"dateAdd\":\"2017-09-18 00:00:00\",\"id\":6,\"uid\":4},\"msg\":\"success\"}";
    }

    //签到
    //参数名	数据类型	备注	必填
    //token	String	登录接口返回的登录凭证	Y
    @GetMapping("/sign")
    public String sign(){
        return "{\"code\":0,\"data\":{\"continuous\":1,\"dateAdd\":\"2017-09-18 00:00:00\",\"id\":6,\"uid\":4},\"msg\":\"success\"}";
    }

    //查询签到记录
    //参数名	数据类型	备注	必填
    //token	String	登录接口获取的登录凭证	Y
    //dateAddBegin	String	起始时间筛选，2017-11-22	X
    //dateAddEnd	String	截止时间筛选，2017-11-22	X
    //page	int	获取第几页数据，不传默认为1	X
    //pageSize	int	每页显示多少条数据，不传默认为50	X
    @GetMapping("/sign/logs")
    public String signLogs(@RequestParam(required = false) String dateAddBegin,
                           @RequestParam(required = false) String dateAddEnd,
                           Page page){
        return "{\"code\":0,\"data\":{\"result\":[{\"continuous\":1,\"dateAdd\":\"2017-11-22 00:00:00\"},{\"continuous\":3,\"dateAdd\":\"2017-11-13 00:00:00\"},{\"continuous\":2,\"dateAdd\":\"2017-11-12 00:00:00\"}],\"totalRow\":19,\"totalPage\":1},\"msg\":\"success\"}";
    }

    //积分明细记录
    //参数名	数据类型	备注	必填
    //token	String	登录接口返回的登录凭证	Y
    //type	int	类型 0 注册 1 邀请好友 2 每日签到 3 兑换优惠券 4 管理员调整 5充值送 6 消费返	X
    //behavior	int	收支方式 0 收入 1 支出	X
    //remark	String	备注关键词搜索	X
    //dateAddBegin	String	起始时间筛选，2017-11-22	X
    //dateAddEnd	String	截止时间筛选，2017-11-22	X
    //page	int	获取第几页数据，不传默认为1	X
    //pageSize	int	每页显示多少条数据，不传默认为50	X
    @GetMapping("/logs")
    public String logs(@RequestParam(required = false) int type,
                       @RequestParam(required = false) int behavior,
                       @RequestParam(required = false) String remark,
                       @RequestParam(required = false) String dateAddBegin,
                       @RequestParam(required = false) String dateAddEnd,
                       Page page){
        return "{\"code\":0,\"data\":{\"result\":[{\"behavior\":0,\"behaviorStr\":\"收入\",\"dateAdd\":\"2017-11-22 17:41:03\",\"remark\":\"签到送积分\",\"score\":1,\"scoreLeft\":25,\"type\":2,\"typeStr\":\"每日签到\"},{\"behavior\":0,\"behaviorStr\":\"收入\",\"dateAdd\":\"2017-11-13 08:11:24\",\"remark\":\"签到送积分\",\"score\":1,\"scoreLeft\":24,\"type\":2,\"typeStr\":\"每日签到\"}],\"totalRow\":24,\"totalPage\":1},\"msg\":\"success\"}";
    }




    //获取签到赠送积分规则
    @GetMapping("/sign/rules")
    public JSON rules(){
        return JSONObject.parseArray("[{\"continuous\":1,\"score\":1},{\"continuous\":2,\"score\":1},{\"continuous\":3,\"score\":1},{\"continuous\":4,\"score\":2},{\"continuous\":5,\"score\":2},{\"continuous\":6,\"score\":2},{\"continuous\":7,\"score\":10}]");
    }

}
