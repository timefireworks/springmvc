package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author: San Jinhong
 * date: 2018/9/26 10:48
 **/
@Controller
public class MyViewController {

    /**
     * @description:  
     * @param null
     * @return:  
     * @author: San Jinhong
     * @date: 2018/9/26 10:51
     *
     * 自定义视图
     */
    @RequestMapping("testMyView")
    public String testView(){
        System.out.println("testMyView");
        return "helloView";
    }
}
