package com.webstoreapp.mybatis;

import com.webstoreapp.entity.User;
import com.webstoreapp.entity.UserData;
import javax.inject.Inject;
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

    public User getUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }

    public User getUserById(Integer userId) {
        return userMapper.selectUserById(userId);
    }

    public User updateUser(String username, User newUser) {
        newUser.generatePasswordHash();
        userMapper.updateUser(username, newUser);
        return newUser;
    }

    public void createUserData(Integer userid) {
        userMapper.insertUserData(userid);
    }

    public void updateUserData(String username, UserData newUserData) {
        userMapper.updateUserData(username, newUserData);
    }

    public UserData getUserDataByUserId(Integer userId) {
        return userMapper.selectUserDataByUserId(userId);
    }

}
