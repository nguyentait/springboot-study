package com.example.demo.exception.item;

public class UploadFileErrorException extends RuntimeException{
    public UploadFileErrorException(String message){
        super(message);
    }
}
