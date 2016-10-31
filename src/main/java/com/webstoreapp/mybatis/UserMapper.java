package com.webstoreapp.mybatis;

import com.webstoreapp.entity.User;

public interface UserMapper {
    
    void insertUser(User user);
    
    User getUserByName(String name);
    
    void deleteAll();
    
}
