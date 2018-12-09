package com.wenliuz.core.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 生成验证码接口
 * @author wenliuz
 */
public interface ValidateCodeGenerator {

    /**
     * 图形验证码生成器
     * @param request
     * @return
     */
    ImageCode generate(ServletWebRequest request);
}
