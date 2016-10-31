package com.webstoreapp.mybatis;

import com.webstoreapp.entity.User;
import org.mybatis.cdi.Mapper;

import javax.inject.Inject;

public class UserService {

    @Inject
    @Mapper
    private UserMapper userMapper;
    
    public User createUser(User user) {
        user.generatePasswordHash();
        userMapper.insertUser(user);
        return userMapper.getUserByName(user.getUsername());
    }
}
