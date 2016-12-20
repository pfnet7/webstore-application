package com.webstoreapp.authentication;

import com.webstoreapp.entity.User;
import com.webstoreapp.mybatis.UserService;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@RequestScoped
public class AuthenticatedUserProducer {

    @Produces
    @RequestScoped
    @AuthenticatedUser
    private User authenticatedUser;
    
    @Inject
    private UserService userService;

    public void handleAuthenticationEvent(@Observes @AuthenticatedUser Integer userId) {
        this.authenticatedUser = findUser(userId);
    }

    private User findUser(Integer userId) {
        return userService.getUserById(userId);
    }

}
