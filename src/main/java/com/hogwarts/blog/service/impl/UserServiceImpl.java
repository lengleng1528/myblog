package com.hogwarts.blog.service.impl;


import com.hogwarts.blog.mapper.UserMapper;
import com.hogwarts.blog.pojo.User;
import com.hogwarts.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User checkUser(String username, String password) {
        User user = userMapper.findByUsernameAndPassword(username, password);
        return user;
    }
}
