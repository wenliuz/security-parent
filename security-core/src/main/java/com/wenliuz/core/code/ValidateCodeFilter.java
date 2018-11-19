package com.wenliuz.core.code;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 图形验证码过滤器
 * @author wenliuz
 */
public class ValidateCodeFilter extends OncePerRequestFilter {//保证过滤器链执行一次

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    private AuthenticationFailureHandler failureHandler;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        if (StringUtils.equals("/auth/login", request.getRequestURI()) && StringUtils.equalsIgnoreCase(request.getMethod(),"post")) {
            try {
                validate(new ServletWebRequest(request));
            } catch (ValidateCodeException e) {
                failureHandler.onAuthenticationFailure(request,response,e);
                return;
            }
        }
        filterChain.doFilter(request,response);
    }

    public void validate(ServletWebRequest servletWebRequest) throws ServletRequestBindingException {
        ImageCode codeInSession = (ImageCode)sessionStrategy.getAttribute(servletWebRequest,"image_code");
        String codeInRequest = ServletRequestUtils.getStringParameter(servletWebRequest.getRequest(),"code");
        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException("验证码的值不能为空");
        }
        if (codeInSession == null) {
            throw new ValidateCodeException("验证码不存在");
        }
        if (codeInSession.isExpried()) {
            sessionStrategy.removeAttribute(servletWebRequest,"image_code");
            throw new ValidateCodeException("验证码已过期");
        }
        if (!StringUtils.equals(codeInSession.getCode(),codeInRequest)) {
            throw new ValidateCodeException("验证码不匹配");
        }
        sessionStrategy.removeAttribute(servletWebRequest,"image_code");
    }

    public AuthenticationFailureHandler getFailureHandler() {
        return failureHandler;
    }

    public void setFailureHandler(AuthenticationFailureHandler failureHandler) {
        this.failureHandler = failureHandler;
    }
}
