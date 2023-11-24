package com.dogtiger.challus.controller;

import com.dogtiger.challus.dto.IntroReqDto;
import com.dogtiger.challus.dto.PrincipalResDto;
import com.dogtiger.challus.dto.UpdateProfileDetailReqDto;
import com.dogtiger.challus.entity.User;
import com.dogtiger.challus.repository.UserMapper;
import com.dogtiger.challus.security.PrincipalUser;
import com.dogtiger.challus.service.AccountService;
import com.dogtiger.challus.service.AuthService;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PutMapping("/api/account/mypage/{userId}")
    public ResponseEntity<?> updateMypageDetail(@PathVariable int userId,
                                            @RequestBody UpdateProfileDetailReqDto updateProfileDetailReqDto) {
        updateProfileDetailReqDto.setUserId(userId);
        return ResponseEntity.ok(accountService.updateMypageDetail(updateProfileDetailReqDto));
    }

    @DeleteMapping("/api/account/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable int userId) {
        accountService.deleteUser(userId);
        return ResponseEntity.ok("회원 삭제 성공");
    }

    @GetMapping("/api/account/intro")
    public ResponseEntity<?> getIntro(IntroReqDto introReqDto) {
        return ResponseEntity.ok(accountService.getIntro(introReqDto));
    }

    @PostMapping("/api/account/intro")
    public ResponseEntity<?> saveIntro(@RequestBody IntroReqDto introReqDto) {
        return ResponseEntity.ok(accountService.saveIntro(introReqDto));
    }

    @PutMapping("/api/account/intro")
    public ResponseEntity<?> UpdateIntro(@RequestBody IntroReqDto introReqDto) {
        return ResponseEntity.ok(accountService.updateIntro(introReqDto));
    }

    @GetMapping("/api/account/mychallenges")
    public ResponseEntity<?> getMyChallenge() {
        return ResponseEntity.ok(accountService.getMyChallenges());
    }

    @GetMapping("/api/account/myendchallenges")
    public ResponseEntity<?> getMyEndChallenge() {
        return ResponseEntity.ok(accountService.getMyEndChallenge());
    }

    @GetMapping("/api/account/{challengeId}")
    public ResponseEntity<?> getProgress(@PathVariable int challengeId) {
        return ResponseEntity.ok(accountService.getProgress(challengeId));
    }

    @GetMapping("/api/account/{challengeId}/feed")
    public ResponseEntity<?> getChallengeFeeds(@PathVariable int challengeId) {
        System.out.println(challengeId);
        return ResponseEntity.ok(accountService.getChallengeFeeds(challengeId));
    }
}
