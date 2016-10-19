package com.feng.service.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.feng.base.BaseService;
import com.feng.entity.MenuEntity;
import com.feng.entity.RoleEntity;
import com.feng.entity.UserEntity;
import com.feng.model.MenuModel;
import com.feng.model.RoleModel;
import com.feng.model.UserModel;
import com.feng.repositories.UserRepositorie;
import com.feng.service.MenuService;
import com.feng.service.UserService;

@Service
public class UserServiceImpl extends BaseService implements UserService{

	@Autowired
	private UserRepositorie userRepositorie;
	
	@Autowired
	private MenuService menuService;

	@Override
	public UserEntity add(UserEntity user) {
		UserEntity userEntity = userRepositorie.save(user);
		return userEntity;
	}

	@Override
	public UserEntity findById(Long userId) {
		UserEntity user = userRepositorie.findOne(userId);
		return user;
	}

	@Override
	public UserEntity findByUserAccount(String userAccount) {
		loger.debug(String.format("find by userAccount : %s", userAccount));
		UserEntity userEntity = userRepositorie.findByUserAccount(userAccount);
		return userEntity;
	}

	@Override
	public UserModel getCurrentUserDetails() {
		//获取当前用户，获取角色集合
		String userAccount = getCurrentUserAccount();
		UserEntity currentUser = this.findByUserAccount(userAccount);
		Set<RoleEntity> currentUserRoles = currentUser.getRoles();
		
		//获取一级菜单，遍历时级联可获取全部菜单
		List<MenuEntity> entitys = menuService.findAllGreadFirstMenus();
		
		//获取用户的角色
		Set<RoleModel> possessRoles = getRoles(currentUserRoles);
		
		//获取用户拥有的菜单
		List<MenuModel> possessMenus = getPossessMenus(entitys,currentUserRoles);
		
		UserModel userModel = new UserModel(currentUser);
		userModel.setMenus(possessMenus);
		userModel.setRoles(possessRoles);
		
		return userModel;
	}

	
	private String getCurrentUserAccount() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		Object principal = authentication.getPrincipal();
		 if (principal instanceof UserDetails) {
	         return ((UserDetails) principal).getUsername();
	      }
	      if (principal instanceof Principal) {
	         return ((Principal) principal).getName();
	      }
	      return String.valueOf(principal);
	}

	private List<MenuModel> getPossessMenus(List<MenuEntity> entitys,Set<RoleEntity> currentUserRoles) {
		
		//获取所有菜单的set集合
		List<MenuModel> allMenuModels = new ArrayList<>();
		Set<Long> hasMenusId = new HashSet<>();
		
		for (MenuEntity menuEntity : entitys) {
			MenuModel menuModel = new MenuModel(menuEntity);
			allMenuModels.add(menuModel);
		}
		
		//角色过滤，获取用户自己的菜单set集合
		for (RoleEntity roleEntity : currentUserRoles) {
			Set<MenuEntity> menus = roleEntity.getMenus();
			for (MenuEntity menu : menus) {
				hasMenusId.add(menu.getId());
			}
		}
		
		List<MenuModel> selfModelMenus = filterMenus(allMenuModels,hasMenusId);
		
		return selfModelMenus;
	}
	//角色过滤菜单
	private List<MenuModel> filterMenus(List<MenuModel> allMenuModels,Set<Long> hasMenusIds) {
		
		for (MenuModel menuModel : allMenuModels) {
			if(!(hasMenusIds.contains(menuModel.getId())))
				allMenuModels.remove(menuModel);
			List<MenuModel> nestGreadmeuns = menuModel.getMeuns();
			if(nestGreadmeuns != null && nestGreadmeuns.size()>0 )
				filterMenus(nestGreadmeuns,hasMenusIds);
		}
		
		return allMenuModels;
	}

	private Set<RoleModel> getRoles(Set<RoleEntity> currentUserRoles) {
		Set<RoleModel> roleModels = new HashSet<>();
		for (RoleEntity roleEntity : currentUserRoles) {
			roleModels.add(new RoleModel(roleEntity));
		}
		return roleModels;
	}


	@Override
	public UserModel getCurrentUser() {
		
		String userAccount = getCurrentUserAccount();
		UserEntity currentUser = this.findByUserAccount(userAccount);
		
		UserModel userModel = new UserModel(currentUser);
		
		return userModel;
	}

	@Override
	public UserEntity creatUser(UserModel user) {
		
		UserEntity userEntity = user.getUserEntity(user);
		
		userEntity = userRepositorie.save(userEntity);
		
		return null;
	}
	
}
