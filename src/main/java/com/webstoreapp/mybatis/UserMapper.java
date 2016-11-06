package com.webstoreapp.mybatis;

import com.webstoreapp.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    void insertUser(User user);

    User selectUserById(Long id);

    User selectUserByName(String name);

    void updateUser(@Param("id") Long id, @Param("user") User user);

    void deleteAll();

}
