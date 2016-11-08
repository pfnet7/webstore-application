package com.webstoreapp.entity;

import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Session {

    private User user;
    private ZonedDateTime lastSeenDate;

}
