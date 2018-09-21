package com.controllers;

import com.model.Address;
import com.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * author: San Jinhong
 * date: 2018/9/21 15:28
 **/
@Controller
@SessionAttributes(value = "user", types = String.class)
public class ModelAndViewController {

    private static final String SUCCESS = "success";

    /**
     * @description: testModelAndView
     * @param 
     * @return: org.springframework.web.servlet.ModelAndView 
     * @author: San Jinhong
     * @date: 2018/9/21 15:35
     *
     * 目标方法的返回值可以是ModelAndView类型
     * 其中可以包含视图和模型信息
     * SpringMVC会把ModelAndView的model中数据放入到request域对象中
     */
    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView() {
        String viewName = SUCCESS;
        ModelAndView modelAndView = new ModelAndView(SUCCESS);

        //添加mo'xi模型数据到ModelAndView中
        modelAndView.addObject("time", new Date());

        return modelAndView;
    }

    /**
     * @description: testMap
     * @param map
     * @return: java.lang.String 
     * @author: San Jinhong
     * @date: 2018/9/21 16:01
     *
     * 目标方法可以添加Map类型的参数, 实际上也可以是ModelMap类型或者Model类型
     */
    @RequestMapping("testMap")
    public String testMap(Map<String, Object> map){
        System.out.println(map.getClass().getName());
        map.put("names", Arrays.asList("aa","bb","cc"));
        return SUCCESS;
    }

    /**
     * @description: testSessionAttributes
     * @param map
     * @return: java.lang.String 
     * @author: San Jinhong
     * @date: 2018/9/21 16:50
     *
     * SessionAttributes 通过属性名指定需要放到会话中的属性（value属性）
     *                   通过模型属性的对象类型指定哪些模型属性需要放到会话中（types属性）
     *
     * 该注解只能放在类的上面，不能修饰方法
     */
    @RequestMapping("testSessionAttributes")
    public String testSessionAttributes(Map<String, Object> map){
        Address address = new Address("zhejiang","hangzhou");
        User user = new User(1,"Tom", "123456", "tom@123.com", 15, address);
        map.put("user", user);
        map.put("school", "zzzzz");
        return SUCCESS;
    }
}
