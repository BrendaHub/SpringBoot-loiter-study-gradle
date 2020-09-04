package com.loiter.juc;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @Fun Description //TODO
 * @Date 2020/9/4 21:02 04
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
@Data
@Accessors(chain = true)
@ToString
public class Foo {

    private String name;
    private String address;
    private String email;
    private LocalDateTime localDateTime;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", localDateTime=" + localDateTime +
                ", age=" + age +
                '}';
    }
}
