package com.food.user.userService.exception;

public class NullIdNotAllowed extends RuntimeException {
    public NullIdNotAllowed(String s){
        super(s);
    }
}
