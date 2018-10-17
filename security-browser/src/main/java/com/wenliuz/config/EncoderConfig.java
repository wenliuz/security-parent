package com.wenliuz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by wenliu on 2018/10/14.
 */
@Configuration
public class EncoderConfig {
    //密码加密解密

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();//自定义加密类实现PasswordEncoder
    }
}
