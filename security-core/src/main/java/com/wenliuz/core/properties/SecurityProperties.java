package com.wenliuz.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 定义属性
 * @author wenliuz
 */
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
