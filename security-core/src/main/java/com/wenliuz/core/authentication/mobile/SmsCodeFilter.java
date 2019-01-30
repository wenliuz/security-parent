package com.wenliuz.core.authentication.mobile;

import com.wenliuz.core.code.ImageCode;
import com.wenliuz.core.code.ValidateCode;
import com.wenliuz.core.code.ValidateCodeException;
import com.wenliuz.core.properties.SecurityProperties;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 短信验证码过滤器
 * @author wenliuz
 */
public class SmsCodeFilter extends OncePerRequestFilter implements InitializingBean {//保证过滤器链执行一次

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    private AuthenticationFailureHandler failureHandler;

    private SecurityProperties securityProperties;

    //存储需要过滤的请求
    private Set<String> urls = new HashSet<>();

    private AntPathMatcher pathMatcher = new AntPathMatcher();



    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        String[] configUrls =
                StringUtils.splitByWholeSeparatorPreserveAllTokens(securityProperties.getCode().getSms().getUrl(),",");
        for (String url : configUrls) {
            urls.add(url);
        }
        //加入默认的登录请求
        urls.add("/auth/mobile");
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        boolean flag = false;
        //匹配路径
        for (String url : urls) {
            if (pathMatcher.match(url,request.getRequestURI())) {
                flag = true;
                break;
            }
        }

        if (flag && StringUtils.equalsIgnoreCase(request.getMethod(),"post")) {
            try {
                this.validate(new ServletWebRequest(request));
            } catch (ValidateCodeException e) {
                failureHandler.onAuthenticationFailure(request,response,e);
                return;
            }
        }
        filterChain.doFilter(request,response);
    }

    public void validate(ServletWebRequest servletWebRequest) throws ServletRequestBindingException {
        ValidateCode codeInSession = (ValidateCode)sessionStrategy.getAttribute(servletWebRequest,"sms_code");
        String codeInRequest = ServletRequestUtils.getStringParameter(servletWebRequest.getRequest(),"smsCode");
        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException("验证码的值不能为空");
        }
        if (codeInSession == null) {
            throw new ValidateCodeException("验证码不存在");
        }
        if (codeInSession.isExpried()) {
            sessionStrategy.removeAttribute(servletWebRequest,"sms_code");
            throw new ValidateCodeException("验证码已过期");
        }
        if (!StringUtils.equals(codeInSession.getCode(),codeInRequest)) {
            throw new ValidateCodeException("验证码不匹配");
        }
        sessionStrategy.removeAttribute(servletWebRequest,"sms_code");
    }

    public AuthenticationFailureHandler getFailureHandler() {
        return failureHandler;
    }

    public void setFailureHandler(AuthenticationFailureHandler failureHandler) {
        this.failureHandler = failureHandler;
    }

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}
