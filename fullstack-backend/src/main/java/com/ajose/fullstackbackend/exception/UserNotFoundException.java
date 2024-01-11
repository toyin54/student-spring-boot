package com.ajose.fullstackbackend.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id){
        super("User Not Found");
    }
}
