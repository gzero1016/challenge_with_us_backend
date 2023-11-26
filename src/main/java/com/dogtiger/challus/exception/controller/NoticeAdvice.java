package com.dogtiger.challus.exception.controller;

import com.dogtiger.challus.exception.InvalidDateRangeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NoticeAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException illegalArgumentException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(illegalArgumentException.getMessage());
    }

}