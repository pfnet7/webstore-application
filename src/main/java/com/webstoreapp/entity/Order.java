package com.webstoreapp.entity;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Order {

    private Offer offer;
    private User user;
    private Status status;
    private Address address;

    private enum Status {
        CREATED, SENT, COMPLETED
    }

}
