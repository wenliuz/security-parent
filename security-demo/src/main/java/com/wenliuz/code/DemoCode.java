package com.wenliuz.code;

import com.wenliuz.core.code.ImageCode;
import com.wenliuz.core.code.ValidateCodeGenerator;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 自定义验证码生成
 */
//@Component("imageCodeGenerator")
public class DemoCode implements ValidateCodeGenerator {
    /**
     * 图形验证码生成器
     *
     * @param request
     * @return
     */
    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("自定义验证码生成器");
        return null;
    }
}
