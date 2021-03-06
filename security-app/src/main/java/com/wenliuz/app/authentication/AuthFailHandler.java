package com.wenliuz.app.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wenliuz.core.enums.LoginType;
import com.wenliuz.core.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败返回
 * @author wenliuz
 */
@Component
public class AuthFailHandler extends SimpleUrlAuthenticationFailureHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthFailHandler.class);

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException e) throws IOException, ServletException {
        LOGGER.info("登录失败！");
        if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType("application/json;charset=UTF-8");
            //response.getWriter().write(objectMapper.writeValueAsString(e));
            response.getWriter().write(objectMapper.writeValueAsString(e.getMessage()));
        } else {
            super.onAuthenticationFailure(request,response,e);
        }

    }
}
