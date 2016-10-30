/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybatis;

import com.entity.User;
import javax.inject.Inject;
import org.mybatis.cdi.Mapper;

/**
 *
 * @author Nomysz
 */
public class UserService {
    
    @Inject
    @Mapper
    private UserMapper userMapper;
    
    public String createUser() {
        userMapper.insertUser(new User("Foo", "Bar", "foo@bar.com"));
        return userMapper.getUserByName("Foo").toString();        
    }
    
}
