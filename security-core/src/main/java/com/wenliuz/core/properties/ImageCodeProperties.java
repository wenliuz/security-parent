package com.wenliuz.core.properties;

/**
 * 图形验证码属性
 * @author wenliuz
 */
public class ImageCodeProperties extends SmsCodeProperties {
    //默认配置
    private int width = 67;
    private int height = 23;

    public ImageCodeProperties() {
        //设置图形验证码默认长度
        setLength(4);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
