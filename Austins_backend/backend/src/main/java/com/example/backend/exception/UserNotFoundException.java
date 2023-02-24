package com.example.backend.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Integer id){
        super("Could not find the user user with id " + id);
    }
}
