/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;

/**
 *
 * @author Nomysz
 */
public class User {
    
    private Integer id;
    private UUID uuid;
    private String username;
    private String password;
    
    @Column(name="email_address")
    private String email_address;
    
    public User() {}
    
    public User(String name, String password, String emailAddress) {
        this.username = name;
        this.password = password;
        this.email_address = emailAddress;
    }
    
    public User(Integer id, String name, String password, String emailAddress) {
        this.id = id;
        this.username = name;
        this.password = password;
        this.email_address = emailAddress;
    }
    
    @Override
    public int hashCode() {
        return uuid.hashCode();
    }
    
    @Override
    public boolean equals(Object object) {
        return this == object || object instanceof User
                    && Objects.equals(uuid, ((User) object).uuid);
    }

    @Override
    public String toString() {
        return String.format("com.entity.User[ id=%d, username=%s,"
                + " emailAddress=%s ]", id, username, email_address);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }
    
}
