package com.wenliuz.core.properties;

/**
 * 图形验证码属性
 * @author wenliuz
 */
public class ImageCodeProperties {
    //默认配置
    private int width = 67;
    private int height = 23;
    private int length = 4;
    private int expireIn = 60;
    /**
     * 需要验证码的请求路径
     */
    private String url;


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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
