package com.wenliuz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by wenliu on 2018/10/14.
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        //httpbasic验证 默认方式
        //http.httpBasic();
        //表单验证
        http.formLogin()
                //表单页面
                .loginPage("/login.html")
                //表单登录请求
                .loginProcessingUrl("/auth/login")
                .and()
                .authorizeRequests()
                //忽略验证
                .antMatchers("/login.html").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable();
    }
}
