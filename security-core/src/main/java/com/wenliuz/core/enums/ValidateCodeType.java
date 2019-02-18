package com.wenliuz.core.enums;

import com.wenliuz.core.constants.SecurityConstant;
import sun.security.util.SecurityConstants;

/**
 * 验证码类型
 * @author wenliuz
 */
public enum ValidateCodeType {
    /**
     * 短信验证码
     */
    SMS {
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstant.SMS_CODE;
        }
    },
    /**
     * 图片验证码
     */
    IMAGE {
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstant.IMAGE_CODE;
        }
    };
    /**
     * 校验时从请求中获取的参数的名字
     * @return
     */
    public abstract String getParamNameOnValidate();
}
