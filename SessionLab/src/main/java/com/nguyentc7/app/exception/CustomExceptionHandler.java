package com.nguyentc7.app.exception;

import com.nguyentc7.app.exception.items.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ExceptionModel handlerNotFoundException(NotFoundException ex, WebRequest req) {
        return new ExceptionModel(HttpStatus.NOT_FOUND, ex.getMessage());
    }
}