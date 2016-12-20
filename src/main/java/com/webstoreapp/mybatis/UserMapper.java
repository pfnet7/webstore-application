package com.webstoreapp.mybatis;

import com.webstoreapp.entity.User;
import com.webstoreapp.entity.UserData;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    void insertUser(User user);

    User selectUserByUsername(String username);

    User selectUserById(Integer userId);

    void updateUser(@Param("username") String username, @Param("user") User user);

    void insertUserData(Integer userId);

    void updateUserData(@Param("username") String username, @Param("userData") UserData userData);

    UserData selectUserDataByUserId(Integer userId);

}
