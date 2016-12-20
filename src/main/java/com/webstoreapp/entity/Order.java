package com.webstoreapp.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {

    private Offer offer;
    private User user;
    private Status status;
    private UserData userData;

    public Order(Offer offer, User user, String status, UserData userData) {
        this.offer = offer;
        this.user = user;
        this.status = Status.valueOf(status);
        this.userData = userData;
    }

    private enum Status {
        CREATED, SENT, COMPLETED
    }

}
