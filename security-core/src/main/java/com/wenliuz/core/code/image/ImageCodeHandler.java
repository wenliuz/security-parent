package com.wenliuz.core.code.image;

import com.wenliuz.core.code.handler.impl.AbstractValidateCodeHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;

/**
 * 图形验证码处理器
 * @author wenliuz
 */
@Component("imageValidateCodeHandler")
public class ImageCodeHandler extends AbstractValidateCodeHandler<ImageCode> {
    /**
     * 发送校验码，由子类实现
     *
     * @param request
     * @param validateCode
     * @throws Exception
     */
    @Override
    protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
        ImageIO.write(imageCode.getImage(), "JPEG", request.getResponse().getOutputStream());
    }
}
