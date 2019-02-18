package com.wenliuz.core.properties;

import lombok.Data;

/**
 * 验证码属性
 * @author wenliuz
 */
@Data
public class ValidateCodeProperties {

    /**
     * 图形验证码
     */
    private ImageCodeProperties image = new ImageCodeProperties();

    /**
     * 短信验证码
     */
    private SmsCodeProperties sms = new SmsCodeProperties();

}
