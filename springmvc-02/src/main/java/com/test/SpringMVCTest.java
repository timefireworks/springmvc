package com.test;

import com.dao.EmployeeDao;
import com.modell.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * author: San Jinhong
 * date: 2018/9/27 9:45
 **/

@Controller
public class SpringMVCTest {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping("/testConversionServiceConverer")
    public String testConverter(@RequestParam("employee")Employee employee){
        System.out.println("save" + employee);
        employeeDao.save(employee);
        return "emps";
    }
}
