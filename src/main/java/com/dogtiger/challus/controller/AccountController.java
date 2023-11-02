package com.dogtiger.challus.controller;

import com.dogtiger.challus.dto.UpdatePasswordReqDto;
import com.dogtiger.challus.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PutMapping("/api/account/{userId}")
    public ResponseEntity<?> updatePassword(@Valid UpdatePasswordReqDto updatePasswordReqDto, BindingResult bindingResult) {

        return ResponseEntity.ok(accountService.updatePassword(updatePasswordReqDto));
    }
}
