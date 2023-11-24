package com.dogtiger.challus.exception.controller;

import com.dogtiger.challus.exception.InvalidDateRangeException;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ChallengeAdvice {

    @ExceptionHandler(InvalidDateRangeException.class)
    public ResponseEntity<?> handleInvalidDateRangeException(InvalidDateRangeException invalidDateRangeException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(invalidDateRangeException.getMessage());
    }

}