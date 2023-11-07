package com.dogtiger.challus.controller;

import com.dogtiger.challus.dto.IntroReqDto;
import com.dogtiger.challus.dto.PrincipalResDto;
import com.dogtiger.challus.dto.UpdateProfileDetailReqDto;
import com.dogtiger.challus.entity.User;
import com.dogtiger.challus.repository.UserMapper;
import com.dogtiger.challus.security.PrincipalUser;
import com.dogtiger.challus.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final UserMapper userMapper;
    @GetMapping("/api/account/principal")
    public ResponseEntity<?> getPrincipal() {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = principalUser.getUser();

        PrincipalResDto principalResDto = user.toPrincipalResDto();
        return ResponseEntity.ok(principalResDto);
    }

    @PutMapping("/api/account/mypage/{userId}")
    public ResponseEntity<?> updateMypageDetail(@PathVariable int userId,
                                            @RequestBody UpdateProfileDetailReqDto updateProfileDetailReqDto) {
        updateProfileDetailReqDto.setUserId(userId);
        System.out.println(updateProfileDetailReqDto);
        return ResponseEntity.ok(accountService.updateMypageDetail(updateProfileDetailReqDto));
    }

    @DeleteMapping("/api/account/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable int userId) {
        System.out.println(userId);
        return ResponseEntity.ok(accountService.deleteUser(userId));
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
