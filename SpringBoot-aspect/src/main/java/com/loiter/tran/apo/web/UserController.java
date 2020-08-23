package com.loiter.tran.apo.web;

import com.loiter.tran.apo.result.ResultBody;
import com.loiter.tran.beans.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    @GetMapping(value = "/user")
    public ResultBody findByUser(User user) {
        System.out.println("用户查询接口请求的参数： " + user);
        ResultBody resultBody = new ResultBody();
        List<User> userList =new ArrayList<>();
        User user2=new User();
        user2.setId(1L);
        user2.setName("xuwujing");
        user2.setAge(18);
        userList.add(user2);
        resultBody.setCode("0");
        resultBody.setResult(userList.toString());
        System.out.println("用户查询接口响应的参数:"+resultBody);
        return resultBody;
    }
}
