package com.controllers;

import com.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * author: San Jinhong
 * date: 2018/9/21 17:16
 **/

@Controller
public class ModelAttributeController {

    private static final String SUCCESS = "success";

    @ModelAttribute
    public void getUser(@RequestParam(value = "id", required = false) Integer id,
                        Map<String, Object> map){
        if(null != null){
            User user = new User(1, "Tom", "123456", "tom@123.com", 12, null);
            System.out.println("从数据库获取一个对象： " + user);
            map.put("user", user);
        }
    }

    @RequestMapping("testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println("修改：" + user);
        return SUCCESS;
    }
}
