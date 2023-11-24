package com.dogtiger.challus.exception.controller;

import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonAdvice {

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<?> handleJwtException(JwtException jwtException) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(jwtException.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleNullPointerException(NullPointerException nullPointerException) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(nullPointerException.getMessage());
    }
}
