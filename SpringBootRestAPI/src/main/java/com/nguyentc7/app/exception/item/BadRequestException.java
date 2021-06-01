package com.nguyentc7.app.exception.item;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
