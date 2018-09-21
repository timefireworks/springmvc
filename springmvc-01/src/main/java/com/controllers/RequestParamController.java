package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestParamController {

    private static final String SUCCESS = "success";

    /**
     * @description: testRequestParam
     * @param username
     * @param age
     * @return: java.lang.String 
     * @author: San Jinhong
     * @date: 2018/9/21 11:04
     *
     * @RequestParam来映射请求参数，
     * value值即为请求参数的参数名
     * required 该参数是否必须，默认为true
     * defaultValue 请求参数默认值
     * 如果接受参数是int型并且非必须可加defaultValue或者用Integer接受，否则无法传值
     */
    @RequestMapping("testRequestParam")
    public String testRequestParam(@RequestParam("username") String username,
                                   @RequestParam(value = "age", required = false) Integer age){
        System.out.println("testRequestParam, username: " + username + " age: " + age);
        return SUCCESS;
    }
}
