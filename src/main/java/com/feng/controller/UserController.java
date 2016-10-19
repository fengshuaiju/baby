package com.feng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.feng.base.BaseController;
import com.feng.entity.UserEntity;
import com.feng.model.UserModel;
import com.feng.service.UserService;
import com.feng.util.exception.ExceptionCode;
import com.feng.util.exception.ValidateUtils;

@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController{

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public UserModel addUser(@PathVariable("id") Long userId){
		
		ValidateUtils.notNull(userId, ExceptionCode.user_USERID_IS_NULL);
		
		loger.debug("find user by id %s ", userId);
		UserEntity user = userService.findById(userId);
		
		UserModel userModel = new UserModel(user);
		
		//UserModel userModel = userService.getCurrentUserDetails();
		
		return userModel;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public UserEntity addUser(@RequestParam(value="userAccount",required=true) String userAccount){
		
		loger.debug("find user by userAccount %s ", userAccount);
		UserEntity user = userService.findByUserAccount(userAccount);
		
		return user;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public UserModel addUser(UserModel user){
		
		ValidateUtils.notNull(user, ExceptionCode.user_USERID_IS_NULL);
		UserEntity userEntity = userService.creatUser(user);
		
		user = new UserModel(userEntity);
		
		return user;
	}
}
