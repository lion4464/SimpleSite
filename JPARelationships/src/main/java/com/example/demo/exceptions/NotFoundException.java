package com.example.demo.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
