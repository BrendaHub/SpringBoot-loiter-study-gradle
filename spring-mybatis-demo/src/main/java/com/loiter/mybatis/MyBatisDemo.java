package com.loiter.mybatis;

import com.loiter.mybatis.endity.User;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class MyBatisDemo {

    public static void main(String[] args) throws Exception {

        DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();

        Resource resource = defaultResourceLoader.getResource( "classpath:/mybatis/mybatis-config.xml");

        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        Reader reader = encodedResource.getReader();

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory build = sqlSessionFactoryBuilder.build(reader);

        Configuration configuration = build.getConfiguration();
        Environment environment = configuration.getEnvironment();
        System.out.println("====");
        DataSource dataSource = environment.getDataSource();

        SqlSession sqlSession = build.openSession();
//        List<User> objects = sqlSession.selectList("selectUser", 0);
//        objects.stream().forEach(System.out::println);

        List<User> objects = sqlSession.selectList("selectByName1", "brenda");
        objects.stream().forEach(System.out::println);
        sqlSession.close();


    }
}
