package com.wanlab.cleanarchiapp.infrastructures.config.exception;


import com.wanlab.cleanarchiapp.domain.exception.BadRequestException;
import com.wanlab.cleanarchiapp.domain.exception.ConflictException;
import com.wanlab.cleanarchiapp.domain.exception.ForbiddenException;
import com.wanlab.cleanarchiapp.domain.exception.NotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse badRequestException(RuntimeException e) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), new Date(), e.getMessage(), e.toString());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse notFoundException(RuntimeException e) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), new Date(), e.getMessage(), e.toString());
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ErrorResponse conflictException(RuntimeException e) {
        return new ErrorResponse(HttpStatus.CONFLICT.value(), new Date(), e.getMessage(), e.toString());
    }

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ErrorResponse forbiddenException(RuntimeException e) {
        return new ErrorResponse(HttpStatus.FORBIDDEN.value(), new Date(), e.getMessage(), e.toString());
    }
}
