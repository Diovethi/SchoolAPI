package com.example.appspring.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class ApiRequestExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public HTTPErrorResponse apiRequestException(ApiRequestException e){
         return new HTTPErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST,  ZonedDateTime.now(ZoneId.of("Z")));
    }
}
