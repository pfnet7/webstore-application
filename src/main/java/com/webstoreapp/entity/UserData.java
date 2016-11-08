package com.webstoreapp.entity;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserData {

    private String name;
    private String surname;
    private Address address;

}
