package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author: San Jinhong
 * date: 2018/9/26 10:54
 **/

@Controller
public class ForwardAndRedirectController {

    @RequestMapping("testRedirect")
    public String testRedirect(){
        System.out.println("testRedirect");
        return "redirect:/index.jsp";
    }

    @RequestMapping("testForward")
    public String testForward(){
        System.out.println("testForward");
        return "success";
    }
}
