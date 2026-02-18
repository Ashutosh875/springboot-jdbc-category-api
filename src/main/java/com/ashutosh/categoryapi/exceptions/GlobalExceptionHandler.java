package com.ashutosh.categoryapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<String> handleDatabase(DatabaseException dbExc){
        return new ResponseEntity<>(dbExc.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResource(ResourceNotFoundException rsExc){
        return new ResponseEntity<>(rsExc.getMessage() , HttpStatus.NOT_FOUND);
    }

}
