/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webstoreapp;


import com.mybatis.UserService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Nomysz
 */
@Path("/addUser")
public class AddUser {
    
    @Inject
    private UserService userService;
    
    @GET
    @Produces("text/plain")
    public String viewUser() {
        return userService.createUser();
    }
    
}
