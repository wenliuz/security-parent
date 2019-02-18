package com.wenliuz.core.code.sms;

import com.wenliuz.core.code.ValidateCode;
import com.wenliuz.core.code.handler.impl.AbstractValidateCodeHandler;
import com.wenliuz.core.constants.SecurityConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import sun.security.util.SecurityConstants;

/**
 * 短信验证码处理器
 * @author wenliuz
 */
@Component("smsValidateCodeHandler")
public class SmsCodeHandler extends AbstractValidateCodeHandler<ValidateCode> {

    /**
     * 短信验证码发送器
     */
    @Autowired
    private SmsCodeSender smsCodeSender;

    /**
     * 发送校验码，由子类实现
     *
     * @param request
     * @param validateCode
     * @throws Exception
     */
    @Override
    protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
        String paramName = SecurityConstant.PARAM_MOBILE;
        String mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), paramName);
        smsCodeSender.send(mobile, validateCode.getCode());
    }
}
