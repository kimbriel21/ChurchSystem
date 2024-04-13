package com.bcf.church.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UsernameNotFound extends RuntimeException{
    private String username;


    public UsernameNotFound(String username) {
        super(String.format("user not found with %s", username));
        this.username = username;
    }
}
