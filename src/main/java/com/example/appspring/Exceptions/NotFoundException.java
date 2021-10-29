package com.example.appspring.Exceptions;

public class NotFoundException  extends RuntimeException{

    public NotFoundException() {

        super("What you have searched don't exist.");
    }

    public NotFoundException(String message) {
        super(message);
    }

}
