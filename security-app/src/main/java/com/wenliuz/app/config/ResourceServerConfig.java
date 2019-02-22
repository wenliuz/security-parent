package com.wenliuz.app.config;

import com.wenliuz.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.wenliuz.core.code.ValidateCodeConfig;
import com.wenliuz.core.constants.SecurityConstant;
import com.wenliuz.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author wenliuz
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private AuthenticationFailureHandler authFailHandler;
    @Autowired
    private AuthenticationSuccessHandler authSuccessHandler;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
    @Autowired
    private ValidateCodeConfig validateCodeConfig;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                //验证码配置
                //.apply(validateCodeConfig).and()
                //social配置，注入filter
                //添加配置项
                .apply(smsCodeAuthenticationSecurityConfig)
                //.apply(socialSecurityConfig)
                .and()
                //表单登录
                .formLogin()
                    //自定义表单的登录请求
                    .loginProcessingUrl(SecurityConstant.LOGIN_URL)
                    //跳转请求
                    .loginPage(SecurityConstant.UNAUTHENTICATION_URL)
                    .successHandler(authSuccessHandler)
                    .failureHandler(authFailHandler)
                    .and()
                .authorizeRequests()
                    //忽略验证
                    .antMatchers(SecurityConstant.UNAUTHENTICATION_URL,
                        securityProperties.getBrowser().getLoginPage(),
                        SecurityConstant.LOGIN_URL_MOBILE,
                        SecurityConstant.VALIDATE_CODE + "/*")
                    .permitAll()
                .anyRequest()
                    .authenticated()
                    .and()
                .csrf()
                    .disable();
    }
}
