package com.webstoreapp.error;

public class InvalidEntityException extends Exception {

    public InvalidEntityException(String errorMessage) {
        super(errorMessage);
    }

}
