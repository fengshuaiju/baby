package com.feng.security.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.feng.entity.RoleEntity;
import com.feng.entity.UserEntity;
import com.feng.service.UserService;
import com.feng.util.exception.ExceptionCode;
import com.feng.util.exception.ValidateUtils;

@Component
public class NormalAuthValidation {

	@Autowired
	private UserService userService;

	public List<GrantedAuthority> validationAccess(String userAccount, String rawPassword) {
		
		UserEntity user = userService.findByUserAccount(userAccount);
		String salt = user.getSalt();
		String password = user.getPassword();
		//验证密码是否正确
		boolean isAccess = checkPassword(rawPassword,salt,password);
		
		ValidateUtils.isTrue(isAccess, ExceptionCode.user_USERNAME_PASSWORD_WRONG);
		
		//查询用户的角色,创建角色信息List
		Set<RoleEntity> roles = user.getRoles();
		List<GrantedAuthority> list = creatGrantedAuthoritys(roles);
		
		return list;
	}
	
	/**
	 * 获取用户角色，封装角色信息
	 * @param roles
	 * @return
	 */
	private List<GrantedAuthority> creatGrantedAuthoritys(Set<RoleEntity> roles) {
		
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		
		if(roles!=null && roles.size()!=0){
			for (RoleEntity role : roles) {
				SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" + role.getRoleName().toUpperCase());
				list.add(simpleGrantedAuthority);
			}
		}else{//如果没有角色，默认分配一个用户角色
			SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
			list.add(simpleGrantedAuthority);
		}
		return list;
	}

	/**
	 * 校验密码是否正确
	 * @param rawPassword
	 * @param salt
	 * @param password
	 * @return
	 */
	private boolean checkPassword(String rawPassword, String salt, String password) {
		
		ShaPasswordEncoder encoder = new ShaPasswordEncoder();
		String encodePassword = encoder.encodePassword(rawPassword, salt);
		
		return password.equals(encodePassword);
	}
	
	public static void main(String[] args) {
		String rawPassword = "fengshuaiju";
		String salt = "kdw5dkwesiws";
		ShaPasswordEncoder encoder = new ShaPasswordEncoder();
		String encodePassword = encoder.encodePassword(rawPassword, salt);
		System.out.println(encodePassword);
	}
}