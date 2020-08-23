package com.loiter.retrofit;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import com.loiter.retrofit.bean.Person;
import com.loiter.retrofit.bean.Result;
import retrofit2.http.GET;
import retrofit2.http.Query;

//@RetrofitClient(baseUrl = "${test.baseUrl}")
@RetrofitClient(baseUrl = "/")
public interface HttpApi {

    @GET("person")
    Result<Person> getPerson(@Query("id") Long id);
}
