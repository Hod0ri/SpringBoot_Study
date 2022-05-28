package com.example.exceptionhandling.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice()
public class GlobalControllerAdvice {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception e) {
        System.out.println("----------------------------------");
        System.out.println(e.getClass().getName());
        System.out.println(e.getLocalizedMessage());
        System.out.println("----------------------------------");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }

    @ExceptionHandler(value = org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentnotvaildex(MethodArgumentNotValidException e) {
        System.out.println("----------------------------------");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
