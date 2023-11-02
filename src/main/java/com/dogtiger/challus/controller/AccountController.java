package com.dogtiger.challus.controller;

import com.dogtiger.challus.dto.UpdateNicknameReqDto;
import com.dogtiger.challus.dto.UpdatePasswordReqDto;
import com.dogtiger.challus.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PutMapping("/api/account/{userId}")
    public ResponseEntity<?> updatePassword(@RequestBody UpdatePasswordReqDto updatePasswordReqDto,
                                            @Valid BindingResult bindingResult,
                                            @PathVariable int userId) {
        updatePasswordReqDto.setUserId(userId);

        return ResponseEntity.ok(accountService.updatePassword(updatePasswordReqDto));
    }

    @PutMapping("/api/account/{userId}")
    public ResponseEntity<?> updateNickname(@PathVariable int userId, @RequestBody UpdateNicknameReqDto updateNicknameReqDto) {
        updateNicknameReqDto.setUserId(userId);

        return ResponseEntity.ok(null);
    }
}
