package com.wenliuz.core.code;

import org.springframework.security.core.AuthenticationException;

/**
 * 验证码自定义异常
 * @author wenliuz
 */
public class ValidateCodeException extends AuthenticationException {
    public ValidateCodeException(String msg) {
        super(msg);
    }
}
