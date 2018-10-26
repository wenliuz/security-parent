package com.wenliuz.core.properties;

/**
 * Project Name:security-parent <br/>
 * Package Name:com.wenliuz.core.properties <br/>
 * Date:2018/10/26 11:35 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="mailto:zhengwl@eastcom-sw.com">zhengwl</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2018 =======================================================
 */
public class BrowserProperties {

    private String loginPage = "/login.html";

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
