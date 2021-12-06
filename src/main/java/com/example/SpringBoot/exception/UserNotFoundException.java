package com.example.SpringBoot.exception;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(String message) {
        super(message);
    }
}
