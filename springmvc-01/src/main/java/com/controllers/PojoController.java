package com.controllers;

import com.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PojoController {

    private static final String SUCCESS = "success";

    /**
     * @description: testPojo
     * @param user
     * @return: java.lang.String 
     * @author: San Jinhong
     * @date: 2018/9/21 14:56
     *
     * SpringMVC会按请求参数名和POJO属性名进行自动匹配，自动为该对象填充属性值，支持级联属性值
     */
    @RequestMapping("testPojo")
    private String testPojo(User user){
        System.out.println(user);
        return SUCCESS;
    }
}
