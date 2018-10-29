package com.wenliuz.core.properties;

import com.wenliuz.core.enums.LoginType;

/**
 * 定义属性
 * @author wenliuz
 */
public class BrowserProperties {

    private String loginPage = "/login.html";

    private LoginType loginType = LoginType.JSON;

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
}
