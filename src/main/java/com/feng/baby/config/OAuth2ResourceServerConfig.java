package com.feng.baby.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {


    public OAuth2ResourceServerConfig(){
        System.err.println("sssssssssssssssssssssssssssssssssssssssssssssss");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/apidocs/**").permitAll()
//                .anyRequest().authenticated();
        .anyRequest().permitAll();
    }
}
