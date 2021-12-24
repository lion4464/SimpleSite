package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ResourceAlreadyExistsExceptionHandler {

    @ExceptionHandler(value = {ResourceAlreadyExistsException.class})
    public ResponseEntity<Object> handleAlreadyExistsException(ResourceAlreadyExistsException e){
        HttpStatus httpBody=HttpStatus.TOO_EARLY;

        ApiException result=new ApiException(
                e.getMessage(),
                httpBody,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(result,httpBody);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(NotFoundException e){
        HttpStatus httpBody=HttpStatus.NOT_FOUND;

        ApiException result=new ApiException(
                e.getMessage(),
                httpBody,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(result,httpBody);
    }

}
