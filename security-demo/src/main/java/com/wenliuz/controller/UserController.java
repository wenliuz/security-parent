package com.wenliuz.controller;

import com.wenliuz.core.properties.SecurityProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wenliuz
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SecurityProperties securityProperties;

    //@GetMapping("/me")
    public Object getCurrentUser(@AuthenticationPrincipal UserDetails user) {
        return user;
    }

    @GetMapping("/me")
    public Object getCurrentUser(Authentication  user, HttpServletRequest request) throws Exception {
        String token = StringUtils.substringAfter(request.getHeader("Authorization"), "Bearer ");

        Claims claims = Jwts.parser().setSigningKey(
                securityProperties.getAuth().getJwtSigningKey().getBytes("UTF-8"))
                .parseClaimsJws(token).getBody();
        // 拿到自定义增强的参数
        String test = (String) claims.get("test");

        System.out.println(test);
        return user;
    }
}
