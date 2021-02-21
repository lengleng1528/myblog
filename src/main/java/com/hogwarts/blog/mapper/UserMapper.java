package com.hogwarts.blog.mapper;

import com.hogwarts.blog.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {

    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
