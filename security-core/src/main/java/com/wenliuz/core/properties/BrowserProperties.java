package com.wenliuz.core.properties;

import com.wenliuz.core.enums.LoginType;

/**
 * 定义浏览器属性
 * @author wenliuz
 */
public class BrowserProperties {

    /**
     * 登录页
     */
    private String loginPage = "/login.html";

    /**
     * 登录方式
     */
    private LoginType loginType = LoginType.JSON;

    /**
     * 记住我 时长
     */
    private Integer rememberMeSeconds = 3600;



    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public Integer getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(Integer rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }
}
