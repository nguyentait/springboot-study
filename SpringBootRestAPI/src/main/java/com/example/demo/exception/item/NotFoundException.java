package com.example.demo.exception.item;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}