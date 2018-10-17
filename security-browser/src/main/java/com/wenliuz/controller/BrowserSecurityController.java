package com.wenliuz.controller;

import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wenliu on 2018/10/17.
 */
@RestController
public class BrowserSecurityController {

    private RequestCache requestCache = new HttpSessionRequestCache();//缓存的http请求

    /**
     * 当需要身份认证时，跳转到这里
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/authRequire")
    public String authRequire(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

}
