package com.feng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feng.base.BaseService;
import com.feng.entity.MenuEntity;
import com.feng.repositories.MenuRepositorie;
import com.feng.service.MenuService;

@Service
public class MenuServiceImpl extends BaseService implements MenuService {

	@Autowired
	private MenuRepositorie menuRepositorie;
	
	@Override
	public MenuEntity findMenuById(Long menuId) {
		
		MenuEntity menuEntity = menuRepositorie.findOne(menuId);
		
		return menuEntity;
	}

	@Override
	public List<MenuEntity> findAllGreadFirstMenus() {
		
		List<MenuEntity> list = menuRepositorie.findAllGreadFirstMenus();
		
		return list;
	}

}
