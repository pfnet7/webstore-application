/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webstoreapp.entity;

import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author Nomysz
 */
@Getter
@ToString
public class Session {

    private User user;
    private ZonedDateTime lastSeenDate;

}
