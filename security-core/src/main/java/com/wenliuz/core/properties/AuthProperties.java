package com.wenliuz.core.properties;


import lombok.Data;

@Data
public class AuthProperties {

    /**
     * jwt签名秘钥
     */
    private String jwtSigningKey = "wenliuz";

}
