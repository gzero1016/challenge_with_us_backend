package com.dogtiger.challus.controller;


import com.dogtiger.challus.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private AccountService accountService;

    @PostMapping("/api/auth/duplicate/{email}")
    public ResponseEntity<?> checkEmailDuplicate(@PathVariable String email){

        boolean isDuplicate = accountService.checkEmailDuplicate(email);

            return ResponseEntity.ok().body(isDuplicate);
    }
}
