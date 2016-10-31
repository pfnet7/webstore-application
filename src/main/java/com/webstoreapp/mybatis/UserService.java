package com.webstoreapp.mybatis;

import javax.inject.Inject;

import com.webstoreapp.entity.User;
import org.mybatis.cdi.Mapper;

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
