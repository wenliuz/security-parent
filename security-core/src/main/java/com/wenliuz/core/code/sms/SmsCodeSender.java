package com.wenliuz.core.code.sms;

/**
 * 短信验证码发送接口
 * @author wenliuz
 */
public interface SmsCodeSender {

    /**
     * 发送短信
     * @param mobile 手机号码
     * @param code 验证码
     */
    void send(String mobile, String code);
}
