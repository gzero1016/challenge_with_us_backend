package com.dogtiger.challus.controller;

import com.dogtiger.challus.dto.IntroReqDto;
import com.dogtiger.challus.dto.UpdateNicknameReqDto;
import com.dogtiger.challus.dto.UpdatePasswordReqDto;
import com.dogtiger.challus.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/api/account/nickname/{userId}")
    public ResponseEntity<?> updateNickname(@PathVariable int userId,
                                            @RequestBody UpdateNicknameReqDto updateNicknameReqDto) {
        updateNicknameReqDto.setUserId(userId);

        return ResponseEntity.ok(accountService.updateNickname(updateNicknameReqDto));
    }

    @GetMapping("/api/account/intro")
    public ResponseEntity<?> getIntro(IntroReqDto introReqDto) {
        System.out.println(introReqDto);
        return ResponseEntity.ok(accountService.getIntro(introReqDto));
    }

    @PostMapping("/api/account/intro")
    public ResponseEntity<?> saveIntro(@RequestBody IntroReqDto introReqDto) {
        System.out.println(introReqDto);
        return ResponseEntity.ok(accountService.saveIntro(introReqDto));
    }

    @PutMapping("/api/account/intro")
    public ResponseEntity<?> UpdateIntro(@RequestBody IntroReqDto introReqDto) {
        System.out.println(introReqDto);
        return ResponseEntity.ok(accountService.updateIntro(introReqDto));
    }
}
