package com.nguyentc7.app.exception;

import com.nguyentc7.app.exception.item.BadRequestException;
import com.nguyentc7.app.exception.item.DuplicateRecordException;
import com.nguyentc7.app.exception.item.NotFoundException;
import com.nguyentc7.app.exception.item.UploadFileErrorException;
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