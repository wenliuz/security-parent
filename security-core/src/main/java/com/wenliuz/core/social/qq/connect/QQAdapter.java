package com.wenliuz.core.social.qq.connect;

import com.wenliuz.core.social.qq.api.QQ;
import com.wenliuz.core.social.qq.api.QQUserInfo;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.core.style.ValueStyler;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @author wenliuz
 */
public class QQAdapter implements ApiAdapter<QQ> {

    /**
     * 测试qq服务是否可用
     * @param api
     * @return
     */
    @Override
    public boolean test(QQ api) {
        return true;
    }


    @Override
    public void setConnectionValues(QQ api, ConnectionValues values) {
        QQUserInfo userInfo = api.getUserInfo();
        values.setDisplayName(userInfo.getNickname());
        values.setProfileUrl(null);
        values.setImageUrl(userInfo.getFigureurl_qq_1());
        values.setProviderUserId(userInfo.getOpenId());
    }


    @Override
    public UserProfile fetchUserProfile(QQ api) {
        return null;
    }


    @Override
    public void updateStatus(QQ api, String message) {

    }
}
