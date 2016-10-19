package com.feng.security.util;

/**
 * 该类用于自定义获取用户信息，userName是登录时的输入的唯一凭证
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService{
	
	@Override
	public UserDetails loadUserByUsername(String userAccount) throws UsernameNotFoundException {
		
		userAccount = "fengshuaiju";
		String password = "123";
		
		//获取用户权限
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
		list.add(simpleGrantedAuthority);
		
		User user = new User(userAccount,password,list);
		
		return user;
	}

}