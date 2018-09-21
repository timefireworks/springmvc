package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Writer;

@Controller
public class ServletAPIController {

    private static final String SUCCESS = "success";

    /**
     * @description: testPojo
     * @param user
     * @param 为什么可以用java的io流直接将内容写到浏览器？
     * @return: java.lang.String 
     * @author: San Jinhong
     * @date: 2018/9/21 14:56
     *
     * SpringMVC会按请求参数名和POJO属性名进行自动匹配，自动为该对象填充属性值，支持级联属性值
     */
    @RequestMapping("testServletAPI")
    private void testPojo(HttpServletRequest request, HttpServletRequest response, Writer out) throws IOException {
        System.out.println("testServletAPI, " + request + ", " + response);
        out.write("hello springmvc");
    }
}
