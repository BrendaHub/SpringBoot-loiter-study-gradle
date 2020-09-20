package com.loiter.mybatis.mapper;

import com.loiter.mybatis.endity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select id,name,age,`desc`,heigth from user where name = #{name}")
    User selectByName1(@Param("name") String name);
}
