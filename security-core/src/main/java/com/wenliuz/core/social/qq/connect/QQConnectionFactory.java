package com.wenliuz.core.social.qq.connect;


import com.wenliuz.core.social.qq.api.QQ;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.oauth2.OAuth2ServiceProvider;

public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

    /**
     *
     * @param providerId 供应商唯一标识
     * @param
     * @param
     */
    public QQConnectionFactory(String providerId, String appId, String appSecret) {
        super(providerId, new QQServiceProvider(appId,appSecret), new QQAdapter());
    }
}
