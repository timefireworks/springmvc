package com.controllers;

import com.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;

/**
 * author: San Jinhong
 * date: 2018/9/21 17:16
 **/

@SessionAttributes("user")
@Controller
public class ModelAttributeController {

    private static final String SUCCESS = "success";

    /**
     * @description: getUser
     * @param id
     * @param map
     * @return: void 
     * @author: San Jinhong
     * @date: 2018/9/25 9:18
     *
     * 1.有@ModelAttribute标记的方法，会在每个目标方法执行之前都会被SpringMVC执行
     * 2.@ModelAttribute注解也可以来修饰目标方法POJO类型的入参，其value属性值有如下的作用：
     *    (1).SpringMVC会使用value属性值在implicitModel中查找对应的对象，若存在则会直接传入到目标方法的入参中
     *    (2).SpringMVC会value为key，POJO类型的对象为value，存入到request中
     */
    @ModelAttribute
    public void getUser(@RequestParam(value = "id", required = false) Integer id,
                        Map<String, Object> map){
        if(null != id){
            User user = new User(1, "Tom", "123456", "tom@123.com", 12, null);
            System.out.println("从数据库获取一个对象： " + user);
            map.put("user", user);
        }
    }

    /**
     * @description: testModelAttribute
     * @param user
     * @return: java.lang.String
     * @author: San Jinhong
     * @date: 2018/9/25 9:22
     *
     * 运行流程：
     * 1.执行@ModelAttribute注解修饰的方法：从数据库中取出对象，把对象放入到了Map中，键为：user
     * 2.SpringMVC从Map中取出User对象，并把表单的请求参数赋给该User对象的对应属性
     * 3.SpringMVC把上述对象传入目标方法的参数
     *
     * 注意：在@ModelAttribute修饰的方法中，放入的Map的键需要和目标方法入参类型的第一个字母小写的字符串一致
     *
     * SpringMVC确定目标方法POJO类型入参的过程
     * 1.确定一个key
     *   1).若目标方法的POJO类型的参数没有使用@ModelAttribute作为修饰，则key为POJO类名第一个字母的小写
     *   2).若使用了@ModelAttribute来修饰，则key为@ModelAttribute注解的value属性值
     * 2.在implicitModel中查找key对应的对象，若存在，则作为入参传入
     *   1).若在@ModelAttribute标记的方法中在Map中保存过，且key和1确定的key一致，则会获取到
     * 3.若implicitModel中不存在key对应的对象，则检查当前的Handler是否使用@SessionAttributes注解修饰，
     *   若使用了该注解，且@SessionAttrebutes注解的value属性值中包含了key，则会从HttpSession中获取key所
     *   对应的vlue值，若镩子则直接传入到目标方法的入参中，若不存在则将抛出异常
     * 4.若Handler没有标识@SessionAttributes注解或@SessionAttributes注解的value值中不包含key，则会
     *   通过反射来传教POJO类型的参数，传入目标方法的参数。
     * 5.SpringMVC会把key和POJO类型的对象保存到implicitModel中，进而会保存到request中
     *
     * 源代码分析的流程：
     * 1.调用@ModelAttribute注解修饰的方法，实际上吧@ModelAttribute方法中Map中的数据放在了implicitModel中。
     * 2.解析请求处理器的目标参数，时间上该目标参数来自于WebDataBinder对象的target属性
     *   1).创建WebDataBinder对象：
     *      1>.确定objectName属性：若传入的attrName属性值为""，则objectName为类名第一个字母小写
     *      注：attrName，若目标方法的POJO属性使用了@ModelAttribute来修饰，则attrName值极为@ModelAttribute
     *      的value属性值
     *
     *      2>.确定target属性：
     *         >.在implicitModel中查找attrName对应的属性值，若存在，ok
     *         >.若不存在：则验证当前Handler是否使用了@SessionAttributes进行修饰，若使用了，则尝试从Session中获取
     *           attrName所对应的属性值，若session中没有对应的属性值，则抛出异常。
     *         >.若Handler没有使用@SessionAttributes进行修饰，或@SessionAttributes中没有使用value值指定的key
     *           和attrName相匹配，则 通过反射创建了POJO对象
     *
     *    2).SpringMVC把表单的请求参数赋给了WebDataBinder的target对应的属性。
     *    3).SpringMVC会把WebDataBinder的attrName和target给到implicitModel，进而传到request域对象中
     *    4).把WebDataBinder的target作为参数传递个目标方法的入参
     *
     */
    @RequestMapping("testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user){  //@ModelAttribute修饰POJO入参时默认是入参类型的第一个字母小写
        System.out.println("修改：" + user );
        return SUCCESS;
    }
}
