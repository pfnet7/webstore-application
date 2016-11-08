package com.webstoreapp.entity;

import lombok.Builder;
import lombok.Getter;

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
