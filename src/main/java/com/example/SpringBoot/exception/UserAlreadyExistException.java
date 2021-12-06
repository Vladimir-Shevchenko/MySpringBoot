package com.example.SpringBoot.exception;

public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
