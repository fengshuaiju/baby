package com.feng.baby.adapter.controller;

import com.feng.baby.application.representation.UserAccountInfo;
import com.feng.baby.application.representation.UserInfo;
import com.feng.baby.application.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * Created by fengshuaiju on 2018-06-29.
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/account")
    @ResponseStatus(HttpStatus.OK)
    public UserAccountInfo amount(@RequestParam String username){
        return userService.getAccount(username);
    }

    @GetMapping("/detail")
    public void detail(){

    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("#oauth2.hasAnyScope('user', 'platform')")
    public Page<UserInfo> userList(@RequestParam(required = false) String date,
                                   @RequestParam(required = false) String phone,
                                   Pageable pageable){
        return userService.userList(phone, date, pageable);
    }




    //注册详细信息
    @GetMapping("/wxapp/register/complex")
    public void complex(){

    }



    ///////////////////提现///////////

    //申请发起一笔提现
    //参数名	数据类型	备注	必填
    //token	String	登录接口返回的登录凭证	Y
    //money	Double	提现金额，100起提	Y
    @GetMapping("/withDraw/apply")
    public String withDrawApply(@RequestParam Double money){
        return "{\"code\":0,\"data\":{\"id\":16,\"money\":1,\"moneyFee\":0.01,\"number\":\"TX1710232021319455\"},\"msg\":\"success\"}";
    }


    //查看提现详情
    //参数名	数据类型	备注	必填
    //token	String	登录接口返回的登录凭证	Y
    //id	int	提现编号的数字ID	Y
    @GetMapping("/withDraw/detail")
    public String withDrawApply(@RequestParam int id){
        return "{\"code\":0,\"data\":{\"dateAdd\":\"2017-10-23 10:42:22\",\"dateUpdate\":\"2017-10-23 10:42:22\",\"id\":1,\"money\":1,\"moneyFee\":0.01,\"number\":\"TX1710230146209524\",\"status\":0,\"statusStr\":\"申请中\"},\"msg\":\"success\"}";
    }

    //获取提现列表
    //参数名	数据类型	备注	必填
    //token	String	登录接口返回的登录凭证	Y
    //page	int	获取第几页数据，不传默认为1	X
    //pageSize	int	每页获取多少条数据，不传默认为50	X
    @GetMapping("/withDraw/list")
    public String withDrawList(Pageable page){
        return "{\"code\":0,\"data\":[{\"dateAdd\":\"2017-10-23 10:42:32\",\"dateUpdate\":\"2017-10-23 10:42:32\",\"id\":16,\"money\":1,\"moneyFee\":0.01,\"number\":\"TX1710232021319455\",\"status\":0,\"statusStr\":\"申请中\",\"uid\":28598,\"userId\":951},{\"dateAdd\":\"2017-10-23 10:42:29\",\"dateUpdate\":\"2017-10-23 10:42:29\",\"id\":7,\"money\":1,\"moneyFee\":0.01,\"number\":\"TX1710232067790417\",\"status\":0,\"statusStr\":\"申请中\",\"uid\":28598,\"userId\":951}],\"msg\":\"success\"}";
    }




}
