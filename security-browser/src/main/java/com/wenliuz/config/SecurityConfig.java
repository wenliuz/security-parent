package com.wenliuz.config;

import com.wenliuz.authentication.AuthFailHandler;
import com.wenliuz.authentication.AuthSuccessHandler;
import com.wenliuz.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.wenliuz.core.authentication.mobile.SmsCodeAuthenticationToken;
import com.wenliuz.core.authentication.mobile.SmsCodeFilter;
import com.wenliuz.core.code.ValidateCodeFilter;
import com.wenliuz.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

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
    @Autowired
    private PersistentTokenRepository persistentTokenRepository;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        //httpbasic验证 默认方式
        //http.httpBasic();
        ValidateCodeFilter validateCodeFilter =  new ValidateCodeFilter();
        validateCodeFilter.setFailureHandler(authFailHandler);
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.afterPropertiesSet();//设置属性

        SmsCodeFilter smsCodeFilter =  new SmsCodeFilter();
        smsCodeFilter.setFailureHandler(authFailHandler);
        smsCodeFilter.setSecurityProperties(securityProperties);
        smsCodeFilter.afterPropertiesSet();//设置属性


        //表单验证
        http.addFilterBefore(smsCodeFilter,UsernamePasswordAuthenticationFilter.class)
            .addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
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
                //记住我
            .rememberMe()
                .tokenRepository(persistentTokenRepository)
                .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                .userDetailsService(userDetailsService)
                .and()
            .authorizeRequests()
            //忽略验证
                .antMatchers("/auth/require",securityProperties.getBrowser().getLoginPage(),"/code/*").permitAll()
                .anyRequest()
                .authenticated()
                .and()
            .csrf()
                .disable()
            .apply(smsCodeAuthenticationSecurityConfig);
    }
}
