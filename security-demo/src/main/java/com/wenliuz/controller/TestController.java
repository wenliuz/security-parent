package com.wenliuz.controller;

import com.wenliuz.bean.FaultCase;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wenliu on 2018/10/14.
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(@RequestBody FaultCase faultCase) {
        System.out.println(faultCase.getStartTime());
        System.out.println(faultCase);
        return "hello test";
    }
}
