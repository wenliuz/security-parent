package com.wenliuz.core.code.sms;

/**
 * 短信验证码接口默认实现
 * @author wenliuz
 */
public class DefaultSmsCodeSender implements SmsCodeSender {
    /**
     * 发送短信
     *
     * @param mobile 手机号码
     * @param code   验证码
     */
    @Override
    public void send(String mobile, String code) {
        System.out.println("发送短信,手机号：" + mobile + "，验证码：" + code);
    }
}
