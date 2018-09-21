package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestHeaderController {
    private static final String SUCCESS = "success";

    /**
     * @description:
     * @param null
     * @return:  
     * @author: San Jinhong
     * @date: 2018/9/21 14:24
     */
    @RequestMapping("testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept-Language") String al){
        System.out.println(al);
        return SUCCESS;
    }
}
