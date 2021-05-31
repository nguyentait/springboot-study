package com.example.demo.exception;

import com.example.demo.exception.item.BadRequestException;
import com.example.demo.exception.item.DuplicateRecordException;
import com.example.demo.exception.item.NotFoundException;
import com.example.demo.exception.item.UploadFileErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse handlerNotFoundException(NotFoundException ex, WebRequest req) {
        return new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }
    @ExceptionHandler(DuplicateRecordException.class)
    public ErrorResponse handlerDuplicateRecordException(DuplicateRecordException ex, WebRequest req) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
    @ExceptionHandler(BadRequestException.class)
    public ErrorResponse handlerBadRequestException(BadRequestException ex, WebRequest req) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
    @ExceptionHandler(UploadFileErrorException.class)
    public ErrorResponse handlerUploadFileErrorException(UploadFileErrorException ex, WebRequest req) {
        return new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE, ex.getMessage());
    }

}