package com.feng.baby.adapter.controller;

import com.feng.baby.application.command.DeleteAddress;
import com.feng.baby.application.command.UserAddressAddOrUpdate;
import com.feng.baby.application.representation.Address;
import com.feng.baby.application.service.UserAddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserAddressController {

    private final UserAddressService userAddressService;

    @Autowired
    public UserAddressController(UserAddressService userAddressService) {
        this.userAddressService = userAddressService;
    }


    //获取用户所有的收货地址
    @GetMapping("/shipping-address/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Address> addressList(@RequestParam String username){
        return userAddressService.addressList(username);
    }


    //获取用户默认的收货地址
    @GetMapping("/shipping-address/default")
    @ResponseStatus(HttpStatus.OK)
    public Address addressDefault(@RequestParam String username){
        return userAddressService.defaultAddress(username);
    }

    //获取详细的收货地址
    @GetMapping("/shipping-address/detail")
    @ResponseStatus(HttpStatus.OK)
    public Address addressDetail(@RequestParam String userAddressId, @RequestParam String username){
        return userAddressService.findAddress(userAddressId, username);
    }

    //添加或修改收货地址
    @PostMapping("/shipping-address/addOrUpdate")
    @ResponseStatus(HttpStatus.CREATED)
    public void shippingAddressAdd(@RequestBody UserAddressAddOrUpdate userAddressAddOrUpdate){
        userAddressService.newAddress(userAddressAddOrUpdate.getUsername(), userAddressAddOrUpdate);
    }

    //删除收货地址
    @DeleteMapping("/shipping-address/delete")
    @ResponseStatus(HttpStatus.OK)
    public void addressDelete(@RequestBody DeleteAddress deleteAddress){
        userAddressService.delete(deleteAddress.getUserAddressId(), deleteAddress.getUsername());
    }
}
