package com.wenliuz.config;

import com.wenliuz.authentication.AuthFailHandler;
import com.wenliuz.authentication.AuthSuccessHandler;
import com.wenliuz.core.code.ValidateCodeFilter;
import com.wenliuz.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by wenliu on 2018/10/14.
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthSuccessHandler authSuccessHandler;
    @Autowired
    private AuthFailHandler authFailHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        //httpbasic验证 默认方式
        //http.httpBasic();
        ValidateCodeFilter validateCodeFilter =  new ValidateCodeFilter();
        validateCodeFilter.setFailureHandler(authFailHandler);
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.afterPropertiesSet();//设置属性


        //表单验证
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                //自定义表单页面
                //.loginPage("/login.html")
                //自定义表单的登录请求
                .loginProcessingUrl("/auth/login")
                //跳转请求
                .loginPage("/auth/require")
                .successHandler(authSuccessHandler)
                .failureHandler(authFailHandler)
                .and()
                .authorizeRequests()
                //忽略验证
                .antMatchers("/auth/require",securityProperties.getBrowser().getLoginPage(),"/code/image").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable();
    }
}
