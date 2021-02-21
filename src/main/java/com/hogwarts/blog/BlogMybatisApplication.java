package com.hogwarts.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//相当于给这个包所有类都加了mapper注解
@MapperScan(value = "com.hogwarts.blog.mapper")
@SpringBootApplication
public class BlogMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogMybatisApplication.class, args);
    }

}
