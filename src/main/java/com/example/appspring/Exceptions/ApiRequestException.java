package com.example.appspring.Exceptions;

public class ApiRequestException extends RuntimeException{

    public ApiRequestException() {
        super("What you have searched don't exist.");
    }

    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
