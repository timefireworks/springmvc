package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:San Jinhong
 * @create:2018-09-12 17:40:08
 **/
@Controller
public class HelloWorld {

    public static final String SUCCESS = "success";

    /**
     *
     * @Author: San Jinhong
     * @Date: 2018/9/13 9:16
     *
     * 1.使用@RequestMapping注解来映射请求的URL
     * 2.返回值会通过视图解析器解析为实际的物理视图，对于InternalResourceViewResolver视图解析器，会做如下解析：
     * 通过prefix + returnVal + suffix 这样的方式得到实际的物理视图，然后做转发操作
     *
     * /WEB-INF/views/success.jsp
     */
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello world");
        return SUCCESS;
    }

    /***
     * @Params: id
     * @Return: java.lang.String 
     * @Author: San Jinhong
     * @Date: 2018/9/13 14:17
     *
     * @PathVariable 可以来映射URL中的占位符到目标方法的参数中
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id){
        System.out.println(id);
        return  SUCCESS;
    }

    @RequestMapping("/testRest/{id}")
    public String testRest(@PathVariable("id") Integer id){
        System.out.println(id);
        return  SUCCESS;
    }
}
