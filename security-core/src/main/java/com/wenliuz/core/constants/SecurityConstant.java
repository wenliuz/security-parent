package com.wenliuz.core.constants;

/**
 * 定义常量
 * @author wenliuz
 */
public interface SecurityConstant {
    /**
     * 默认处理验证码的前缀
     */
    String VALIDATE_CODE = "/code";
    /**
     * 当请求需要身份认证时，默认跳转的url
     *
     */
    String UNAUTHENTICATION_URL = "/auth/require";
    /**
     * 默认的用户名密码登录请求处理url
     */
    String LOGIN_URL = "/auth/login";
    /**
     * 默认的手机验证码登录请求处理url
     */
    String LOGIN_URL_MOBILE = "/auth/mobile";
    /**
     * 默认登录页面
     */
    String LOGIN_PAGE = "/login.html";
    /**
     * 验证图片验证码时，http请求中默认的携带图片验证码信息的参数的名称
     */
    String IMAGE_CODE = "imageCode";
    /**
     * 验证短信验证码时，http请求中默认的携带短信验证码信息的参数的名称
     */
    String SMS_CODE = "smsCode";
    /**
     * 发送短信验证码 或 验证短信验证码时，传递手机号的参数的名称
     */
    String PARAM_MOBILE = "mobile";
    /**
     * session失效默认的跳转地址
     */
    String SESSION_INVALID_URL = "/session/invalid";

}
