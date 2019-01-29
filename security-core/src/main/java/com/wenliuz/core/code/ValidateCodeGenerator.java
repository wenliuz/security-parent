package com.wenliuz.core.code;

import com.sun.org.apache.bcel.internal.classfile.Code;
import org.apache.commons.lang.Validate;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 生成验证码接口
 * @author wenliuz
 */
public interface ValidateCodeGenerator {

    /**
     * 验证码生成器
     * @param request
     * @return
     */
    ValidateCode generate(ServletWebRequest request);
}
