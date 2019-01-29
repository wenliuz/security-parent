package com.wenliuz.core.properties;

/**
 * 短信验证码属性
 * @author wenliuz
 */
public class SmsCodeProperties {
    //默认配置
    private int length = 6;
    private int expireIn = 60;
    /**
     * 需要验证码的请求路径
     */
    private String url;

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
