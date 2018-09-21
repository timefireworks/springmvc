package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author:San Jinhong
 * @create:2018-09-12 17:40:08
 **/
@Controller
public class HelloWorld {

    private static final String SUCCESS = "success";

    /*@Autowired
    private StudentService studentService;*/

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

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
    public String testRestGet(@PathVariable("id") Integer id){
        System.out.println("testRest Get" + id);
        return  SUCCESS;
    }
    @RequestMapping(value = "/testRest", method = RequestMethod.POST)
    public String testRestPost(){
        System.out.println("testRest Post");
        return  SUCCESS;
    }
    /**
     * @Description: testRestDelete
     * @Params: id
     * @Return: java.lang.String 
     * @Author: San Jinhong
     * @Date: 2018/9/20 11:34
     *
     * Rest风格的URL
     * 以CRUD为例：
     * 新增：/order/1 POST
     * 修改：/order/1 PUT      update?id=1
     * 获取：/order/1 GET      get?id=1
     * 删除：/order/1 DELETE   delete?id=1
     *
     * 如何发送PUT请求和DELETE请求：
     * 1、需要配置HiddenHttpMethodFilter
     * 2、需要发送POST请求
     * 3、需要发送POST请求时携带一个name="_method"的隐藏域，值为DELETE或PUT
     *
     * 在SpringMVC的目标方法中如何得到id:
     * 使用@PathVariable注解，值和请求中的一致
     */
    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable("id") Integer id){
        //studentService.removeStudent(id);
        System.out.println("testRest Delete" + id);
        return  SUCCESS;
    }
    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
    public String testRestPut(@PathVariable("id") Integer id){
        System.out.println("testRest Put" + id);
        return  SUCCESS;
    }
}
