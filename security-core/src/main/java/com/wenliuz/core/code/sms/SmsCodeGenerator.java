package com.wenliuz.core.code.sms;


import com.sun.org.apache.bcel.internal.classfile.Code;
import com.wenliuz.core.code.ImageCode;
import com.wenliuz.core.code.ValidateCode;
import com.wenliuz.core.code.ValidateCodeGenerator;
import com.wenliuz.core.properties.SecurityProperties;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import javax.naming.Name;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 短信验证码生成器
 * @author wenliuz
 */
@Component("smsCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 短信验证码生成
     *
     * @param request
     * @return
     */
    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());
    }


    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}
