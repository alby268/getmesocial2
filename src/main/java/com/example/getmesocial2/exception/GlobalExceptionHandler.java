package com.example.getmesocial2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RestrictedInfoException.class)
    public ResponseEntity<String> restrictedInfoError(RestrictedInfoException ex) {

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//        return ex.getMessage();


    }


    @ExceptionHandler(RestrictedInfoException.class)
    public ResponseEntity<String> invalidTokenError(InvalidIdToken ex) {

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//        return ex.getMessage();


    }


    @ExceptionHandler(RestrictedNameException.class)
    public ResponseEntity<String> restrictedNameError(RestrictedNameException ex) {

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//        return ex.getMessage();


    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> noSuchElementError() {

        return new ResponseEntity<>("No such element found", HttpStatus.CONFLICT);


    }

}




