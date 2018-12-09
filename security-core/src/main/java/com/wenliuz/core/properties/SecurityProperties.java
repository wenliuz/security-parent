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
}
