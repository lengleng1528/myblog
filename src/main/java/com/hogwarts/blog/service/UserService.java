package com.hogwarts.blog.service;

import com.hogwarts.blog.pojo.User;

public interface UserService {

    User checkUser(String username, String password);

}
