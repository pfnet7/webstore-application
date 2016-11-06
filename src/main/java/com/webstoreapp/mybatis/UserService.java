package com.webstoreapp.mybatis;

import javax.inject.Inject;

import com.webstoreapp.entity.User;
import org.apache.ibatis.annotations.Param;
import org.mybatis.cdi.Mapper;

public class UserService {

    @Inject
    @Mapper
    private UserMapper userMapper;

    public User createUser(User user) {
        user.generatePasswordHash();
        userMapper.insertUser(user);
        return user;
    }

    public User getUserById(Long id) {
        return userMapper.selectUserById(id);
    }

    public User updateUser(@Param("id") Long id, User newUser) {
        newUser.generatePasswordHash();
        userMapper.updateUser(id, newUser);
        return newUser;
    }

}
