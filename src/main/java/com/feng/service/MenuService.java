package com.feng.service;

import java.util.List;

import com.feng.entity.MenuEntity;

public interface MenuService {

	/**
	 * 根据MenuId查找菜单信息
	 * @param menuId
	 * @return
	 */
	MenuEntity findMenuById(Long menuId);
	
	/**
	 * 查找所有菜单
	 * @return
	 */
	List<MenuEntity> findAllGreadFirstMenus();

}
