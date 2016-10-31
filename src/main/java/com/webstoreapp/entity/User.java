/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webstoreapp.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Nomysz
 */
@Getter
@ToString
@RequiredArgsConstructor
public class User {

    @NonNull
    private String username;

    @NonNull
    @Getter(AccessLevel.NONE)
    private String password;

    @NonNull
    private String emailAddress;

    private boolean isAdmin;

    private UserData userData;

}
