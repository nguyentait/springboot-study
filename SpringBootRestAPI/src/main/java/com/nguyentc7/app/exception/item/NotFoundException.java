package com.nguyentc7.app.exception.item;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}