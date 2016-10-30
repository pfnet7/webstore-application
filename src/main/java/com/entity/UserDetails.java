/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author Nomysz
 */
public class UserDetails {
    
    private Integer id;
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String countryName;
    private String cityName;
    private String streetName;
    private String phoneNumber;
    private String zipCode;
    private String stateName;
    
    @Override
    public int hashCode() {
        return uuid.hashCode();
    }
    
    @Override
    public boolean equals(Object object) {
        return this == object || object instanceof UserDetails
                    && Objects.equals(uuid, ((UserDetails) object).uuid);
    }

    @Override
    public String toString() {
        return String.format("com.entity.UserDetails[ id=%d, firstName=%s, "
                + "lastName=%s, countryName=%s, cityName=%s, streetName=%s, "
                + "phoneNumber=%s, zipCode=%s, stateName=%s ]",
                id, firstName, lastName, countryName, cityName, streetName,
                phoneNumber, zipCode, stateName);
    }
    
}
