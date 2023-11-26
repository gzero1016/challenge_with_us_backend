package com.dogtiger.challus.controller;


import com.dogtiger.challus.dto.*;
import com.dogtiger.challus.entity.User;
import com.dogtiger.challus.security.PrincipalUser;
import com.dogtiger.challus.service.AccountService;
import com.dogtiger.challus.service.AuthService;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AccountService accountService;
    private final AuthService authService;
    private final BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/api/auth/principal")
    public ResponseEntity<?> getPrincipal() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        System.out.println(principal);

        if(principal == "anonymousUser") {
            throw new JwtException("사용자 정보가 없습니다.");
        }

        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = principalUser.getUser();

        PrincipalResDto principalResDto = user.toPrincipalResDto();
        return ResponseEntity.ok(principalResDto);
    }

    @GetMapping("/api/auth/duplicate/{email}")
    public ResponseEntity<?> checkEmailDuplicate(@PathVariable String email) {

        boolean isDuplicate = accountService.checkEmailDuplicate(email);

        return ResponseEntity.ok().body(isDuplicate);
    }

    @PostMapping("/api/auth/sign-up")
    public ResponseEntity<?> signUp(@RequestBody SignupReqDto signupReqDto, BindingResult bindingResult) {
        return ResponseEntity.ok(authService.signup(signupReqDto));
    }

    @PostMapping("/api/auth/sign-in")
    public ResponseEntity<?> signIn(@RequestBody SigninReqDto signinReqDto) {
        return ResponseEntity.ok(authService.signin(signinReqDto));
    }

    @GetMapping("/api/admin/members/count")
    public ResponseEntity<?> getUserCount() {
        return ResponseEntity.ok(authService.getMembersCount());
    }

    @GetMapping("/api/admin")
    public ResponseEntity<?> adminListUser() {
        return ResponseEntity.ok(authService.adminListGet());
    }
}