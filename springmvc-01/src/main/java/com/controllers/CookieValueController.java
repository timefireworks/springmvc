package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieValueController {

    private static final String SUCCESS="success";

    @RequestMapping("testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionId){
        System.out.println(sessionId);
        return SUCCESS;
    }
}
