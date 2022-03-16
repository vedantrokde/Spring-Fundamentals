package com.code.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    // add exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> haddleException(StudentNotFoundException e) {

        // create a student error response
        StudentErrorResponse err = new StudentErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage(),
                System.currentTimeMillis());

        // return response entity

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    // add generic expection handler
    public ResponseEntity<StudentErrorResponse> haddleException(Exception e) {

        // create a student error response
        StudentErrorResponse err = new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
                System.currentTimeMillis());

        // return response entity

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
}
