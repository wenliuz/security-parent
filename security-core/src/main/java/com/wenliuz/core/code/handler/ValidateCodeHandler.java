package com.wenliuz.core.code.handler;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码处理器，封装不同验证码处理逻辑
 * @author wenliuz
 */
public interface ValidateCodeHandler {

    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_CODE = "CODE_";

    /**
     * 创建验证码
     * @param request
     */
    void create(ServletWebRequest request) throws Exception;

    /**
     * 校验验证码
     * @param request
     */
    void validate(ServletWebRequest request);
}
