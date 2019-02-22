package com.wenliuz.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * @author wenliuz
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private TokenStore tokenStore;

    /**
     * 当存储类型为redis时，此类不存在，所以加上required=false
     */
    @Autowired(required = false)
    private JwtAccessTokenConverter jwtAccessTokenConverter;


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)
                .tokenStore(tokenStore);
        if (jwtAccessTokenConverter != null) {
            endpoints.accessTokenConverter(jwtAccessTokenConverter);
        }
    }

    /*@Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);
    }*/

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //配置文件里的clientId和secret不起作用，在
        clients.inMemory()
                .withClient("1")
                .secret("123")
                //单位秒
                .accessTokenValiditySeconds(3600)
                //接收的授权模式
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("all","read","write");
                //配置第二个客户端
                //.and().withClient("");
    }


}
