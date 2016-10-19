package com.feng.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.feng.entity.UserEntity;

public class UserModel {
	
	private String userAccount;
	
	private String nickName;
	
	private String moble;
	
	private Set<RoleModel> roles = new HashSet<>();
	
	private List<MenuModel> menus = new ArrayList<>();

	public UserModel(){
	}
	
	public UserModel(UserEntity userEntity){
		this.userAccount = userEntity.getUserAccount();
		this.nickName = userEntity.getNickName();
		this.moble = userEntity.getMoble();
	}
	
	public UserEntity getUserEntity(UserModel user) {
		
		UserEntity userEntity = new UserEntity();
		
		BeanUtils.copyProperties(user, userEntity);
		
		return userEntity;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMoble() {
		return moble;
	}

	public void setMoble(String moble) {
		this.moble = moble;
	}

	public Set<RoleModel> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleModel> roles) {
		this.roles = roles;
	}

	public List<MenuModel> getMenus() {
		return menus;
	}

	public void setMenus(List<MenuModel> menus) {
		this.menus = menus;
	}

	
}
