package com.wenliuz.core.code.image;

import com.wenliuz.core.code.ValidateCode;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 图片验证码
 * @author wenliuz
 */
public class ImageCode extends ValidateCode {
    private BufferedImage image;

    public ImageCode() {

    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        super(code,expireTime);
        this.image = image;
    }

    public ImageCode(BufferedImage image, String code, int expireIn) {
        super(code,expireIn);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

}
