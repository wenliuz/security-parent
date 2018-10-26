package com.wenliuz.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Project Name:security-parent <br/>
 * Package Name:com.wenliuz.core.properties <br/>
 * Date:2018/10/26 11:33 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="mailto:zhengwl@eastcom-sw.com">zhengwl</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2018 =======================================================
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
