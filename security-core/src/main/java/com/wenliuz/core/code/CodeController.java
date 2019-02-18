package com.wenliuz.core.code;

import com.wenliuz.core.code.image.ImageCode;
import com.wenliuz.core.code.sms.SmsCodeSender;
import com.wenliuz.core.constants.SecurityConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import sun.security.util.SecurityConstants;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 生成验证码请求
 * @author wenliuz
 */
@RestController
public class CodeController {

    //图形验证码存在session的key值
    public static final String IMAGE_CODE = "image_code";
    public static final String SMS_CODE = "sms_code";

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Autowired
    private ValidateCodeGenerator imageCodeGenerator;
    @Autowired
    private ValidateCodeGenerator smsCodeGenerator;
    @Autowired
    private SmsCodeSender smsCodeSender;

    @Autowired
    private ValidateCodeHolder validateCodeHolder;


    /**
     * 图形验证码
     * @param request
     * @param response
     * @throws IOException
     */
    /*@GetMapping("/code/image")
    public void imageCode(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ImageCode imageCode = (ImageCode)imageCodeGenerator.generate(new ServletWebRequest(request));
        sessionStrategy.setAttribute(new ServletWebRequest(request), IMAGE_CODE, imageCode);
        ImageIO.write(imageCode.getImage(),"JPEG",response.getOutputStream());
    }*/

    /**
     * 短信验证码
     * @param request
     * @param response
     * @throws IOException
     */
    /*@GetMapping("/code/sms")
    public void smsCode(HttpServletRequest request, HttpServletResponse response) throws IOException,
            ServletRequestBindingException {

        ValidateCode smsCode = smsCodeGenerator.generate(new ServletWebRequest(request));
        sessionStrategy.setAttribute(new ServletWebRequest(request), SMS_CODE, smsCode);
        //从请求获取手机号
        String mobile = ServletRequestUtils.getStringParameter(request,"mobile");
        //发送短信
        smsCodeSender.send(mobile,smsCode.getCode());
    }*/

    /**
     * 创建验证码，根据验证码类型不同，调用不同的 {@link com.wenliuz.core.code.handler.ValidateCodeHandler}接口实现
     *
     * @param request
     * @param response
     * @param type
     * @throws Exception
     */
    @GetMapping(SecurityConstant.VALIDATE_CODE + "/{type}")
    public void createCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type)
            throws Exception {
        validateCodeHolder.findValidateCodeProcessor(type).create(new ServletWebRequest(request, response));
    }



}
