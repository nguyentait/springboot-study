package com.nguyentc7.app.exception.items;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}
