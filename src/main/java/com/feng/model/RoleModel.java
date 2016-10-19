package com.feng.model;

import org.springframework.beans.BeanUtils;

import com.feng.entity.RoleEntity;

public class RoleModel {
	
	private String roleName;
	
	private String note;
	
	public RoleModel(){
	}
	
	public RoleModel(RoleEntity roleEntity){
		BeanUtils.copyProperties(roleEntity, this);
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
