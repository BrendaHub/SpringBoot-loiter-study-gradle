package com.loiter.tran.apo.web;

import com.loiter.tran.apo.pojo.Employee;
import com.loiter.tran.apo.result.ResultBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api1")
public class User1Controller {

    @GetMapping("/h")
    public ResultBody index(Employee employee){
        System.out.println("测试中文乱码");
        List<Employee> employeeList =new ArrayList<>();
        employeeList.add(employee);
        ResultBody rs = new ResultBody();
        rs.setCode("10");
        rs.setResult(employeeList.toString());
        return rs;
    }
}
