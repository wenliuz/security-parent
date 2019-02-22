package com.wenliuz.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 定义属性
 * @author wenliuz
 */
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {
    /**
     * 浏览器属性
     */
    private BrowserProperties browser = new BrowserProperties();

    /**
     * 验证码属性
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();

    /**
     * 社交属性
     */
    private SocialProperties social = new SocialProperties();

    /**
     * oauth2属性
     */
    private AuthProperties auth = new AuthProperties();


    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }

    public SocialProperties getSocial() {
        return social;
    }

    public void setSocial(SocialProperties social) {
        this.social = social;
    }

    public AuthProperties getAuth() {
        return auth;
    }

    public void setAuth(AuthProperties auth) {
        this.auth = auth;
    }
}
