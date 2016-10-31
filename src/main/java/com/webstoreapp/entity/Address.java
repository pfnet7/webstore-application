/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webstoreapp.entity;

import lombok.Builder;
import lombok.Getter;

/**
 *
 * @author Nomysz
 */
@Getter
@Builder
public class Address {

    private String streetName;
    private String houseNumber;
    private String appartmentNumber;
    private String postCode;
    private String cityName;
    private String countryName;

}
