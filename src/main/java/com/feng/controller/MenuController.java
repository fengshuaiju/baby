package com.feng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.feng.base.BaseController;
import com.feng.entity.MenuEntity;
import com.feng.model.MenuModel;
import com.feng.service.MenuService;

@RestController
@RequestMapping("/api/menu")
public class MenuController extends BaseController{

	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value="/{menuId}",method = RequestMethod.GET)
	public MenuModel getMenuInfo(@PathVariable("menuId") Long menuId){
		
		MenuEntity menuEntity = menuService.findMenuById(menuId);
		
		MenuModel menuModel = new MenuModel(menuEntity);
		
		return menuModel;
	}
}
