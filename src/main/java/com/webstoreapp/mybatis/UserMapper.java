/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybatis;

import com.entity.User;

/**
 *
 * @author Nomysz
 */
public interface UserMapper {
    
    void insertUser(User user);
    
    User getUserByName(String name);
    
    void deleteAll();
    
}
