package com.feng.baby.adapter.controller;

import com.feng.baby.application.representation.Address;
import com.feng.baby.application.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fengshuaiju on 2018-06-29.
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/amount")
    public void amount(){

    }

    @GetMapping("/detail")
    public void detail(){

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



    //////////////收货地址///////////////

    //获取用户所有的收货地址
    //参数名	数据类型	备注	必填
    //token	String	调用登录接口返回的登录凭证	Y
    @GetMapping("/shipping-address/list")
    public String addressList(){
        return "{\"code\":0,\"data\":[{\"address\":\"详细地址\",\"areaStr\":\"滨江区\",\"cityId\":330100,\"cityStr\":\"杭州市\",\"code\":\"310000\",\"dateAdd\":\"2017-03-31 15:57:06\",\"dateUpdate\":\"2017-03-31 15:57:06\",\"districtId\":330108,\"id\":2,\"isDefault\":false,\"linkMan\":\"张飞\",\"mobile\":\"13500000001\",\"provinceId\":330000,\"provinceStr\":\"浙江省\",\"status\":0,\"uid\":4,\"userId\":2},{\"address\":\"详细地址\",\"areaStr\":\"滨江区\",\"cityId\":330100,\"cityStr\":\"杭州市\",\"code\":\"310000\",\"dateAdd\":\"2017-03-31 15:56:48\",\"dateUpdate\":\"2017-03-31 15:56:48\",\"districtId\":330108,\"id\":1,\"isDefault\":false,\"linkMan\":\"张飞\",\"mobile\":\"13500000001\",\"provinceId\":330000,\"provinceStr\":\"浙江省\",\"status\":0,\"uid\":4,\"userId\":2}],\"msg\":\"success\"}";
    }


    //获取用户默认的收货地址
    //参数名	数据类型	备注	必填
    //token	String	调用登录接口返回的登录凭证	Y
    @GetMapping("/shipping-address/default")
    public Address addressDefault(@RequestParam String username){
        return userService.defaultAddress(username);
        //return "{\"code\":0,\"data\":{\"address\":\"详细地址\",\"areaStr\":\"滨江区\",\"cityId\":330100,\"cityStr\":\"杭州市\",\"code\":\"310000\",\"dateAdd\":\"2017-03-31 15:57:06\",\"dateUpdate\":\"2017-03-31 15:57:06\",\"districtId\":330108,\"id\":2,\"isDefault\":false,\"linkMan\":\"张飞\",\"mobile\":\"13500000001\",\"provinceId\":330000,\"provinceStr\":\"浙江省\",\"status\":0,\"uid\":4,\"userId\":2},\"msg\":\"success\"}";
    }

    //获取详细的收货地址
    //参数名	数据类型	备注	必填
    //token	String	调用登录接口返回的登录凭证	Y
    //id	int	用户收货地址编号，可通过 list 接口获取	Y
    @GetMapping("/shipping-address/detail")
    public String addressDetail(@RequestParam int id){
        return "{\"code\":0,\"data\":{\"address\":\"详细地址\",\"areaStr\":\"滨江区\",\"cityId\":330100,\"cityStr\":\"杭州市\",\"code\":\"310000\",\"dateAdd\":\"2017-03-31 15:57:06\",\"dateUpdate\":\"2017-03-31 15:57:06\",\"districtId\":330108,\"id\":2,\"isDefault\":false,\"linkMan\":\"张飞\",\"mobile\":\"13500000001\",\"provinceId\":330000,\"provinceStr\":\"浙江省\",\"status\":0,\"uid\":4,\"userId\":2},\"msg\":\"success\"}";
    }

    //添加收货地址
    //参数名	数据类型	备注	必填
    //token	String	调用登录接口返回的登录凭证	Y
    //provinceId	int	所属省份编码	Y
    //cityId	int	所属城市编码	Y
    //districtId	int	所属区县编码	Y
    //linkMan	String	联系人姓名	Y
    //address	String	详细地址	Y
    //mobile	String	收件人手机号码	Y
    //code	String	邮编	Y
    //status	int	状态：0 为正常 1 为停用	X
    //isDefault	Boolean	是否设置为默认收货地址，true 为设置；false 或者不传该参数为 不设置	X
    //idcard	String	身份证号码，国际件使用	X
    @GetMapping("/shipping-address/add")
    public String shippingAddressAdd(@RequestParam int provinceId,
                                     @RequestParam int cityId,
                                     @RequestParam int districtId,
                                     @RequestParam String linkMan,
                                     @RequestParam String address,
                                     @RequestParam String mobile,
                                     @RequestParam String code,
                                     @RequestParam(required = false) int status,
                                     @RequestParam(required = false) boolean isDefault,
                                     @RequestParam(required = false) String idcard){
        return "{\"code\":0,\"msg\":\"success\"}";
    }

    //修改收货地址
    //参数名	数据类型	备注	必填
    //token	String	调用登录接口返回的登录凭证	Y
    //id	int	需要修改的收货地址编号，可通过 list 接口获取	Y
    //-	-	添加接口的参数这里可用，传了某个参数将覆盖该参数原来的值	X
    @GetMapping("/shipping-address/update")
    public String shippingAddressUpdate(@RequestParam(required = false) int provinceId,
                                @RequestParam(required = false) int cityId,
                                @RequestParam(required = false) int districtId,
                                @RequestParam(required = false) String linkMan,
                                @RequestParam(required = false) String address,
                                @RequestParam(required = false) String mobile,
                                @RequestParam(required = false) String code,
                                @RequestParam(required = false) int status,
                                @RequestParam(required = false) boolean isDefault,
                                @RequestParam(required = false) String idcard){

        return "{\"code\":0,\"msg\":\"success\"}";
    }

    //删除收货地址
    //参数名	数据类型	备注	必填
    //token	String	调用登录接口返回的登录凭证	Y
    //id	int	需要删除的收货地址编号，可通过 list 接口获取	Y
    @GetMapping("/shipping-address/delete")
    public String addressDelete(@RequestParam int id){
        return "{\"code\":0,\"msg\":\"success\"}";
    }
}
