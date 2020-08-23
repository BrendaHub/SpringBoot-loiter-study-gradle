package com.loiter.retrofit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private HttpApi httpApi;

    public void test(){
        System.out.println("通过httpApi发起的http请求");
    }
}
