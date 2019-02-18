package com.wenliuz.core.code;

import com.wenliuz.core.code.ValidateCodeException;
import com.wenliuz.core.code.handler.ValidateCodeHandler;
import com.wenliuz.core.enums.ValidateCodeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author wenliuz
 */
@Component
public class ValidateCodeHolder {

    @Autowired
    private Map<String, ValidateCodeHandler> validateCodeHandlers;

    public ValidateCodeHandler findValidateCodeProcessor(ValidateCodeType type) {
        return this.findValidateCodeProcessor(type.toString().toLowerCase());
    }

    public ValidateCodeHandler findValidateCodeProcessor(String type) {
        String name = type.toLowerCase() + ValidateCodeHandler.class.getSimpleName();
        ValidateCodeHandler processor = validateCodeHandlers.get(name);
        if (processor == null) {
            throw new ValidateCodeException("验证码处理器" + name + "不存在");
        }
        return processor;
    }
}
