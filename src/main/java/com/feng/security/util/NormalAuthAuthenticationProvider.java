package com.feng.security.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class NormalAuthAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private NormalAuthValidation normalAuthValidation;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		//登录时的唯一凭证,userName
		Object principal = authentication.getPrincipal();
		//登陆时，输入的密码
		Object credentials = authentication.getCredentials();
		
		if(principal !=null && credentials !=null){
			//校验密码的正确性，并获取角色信息
			List<GrantedAuthority> grantedAuthorityList = normalAuthValidation.validationAccess(principal.toString(),credentials.toString());
			
			UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(principal, credentials, grantedAuthorityList);
			
			return result;
			
		}else{
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
