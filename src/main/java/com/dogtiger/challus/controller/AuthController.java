package com.dogtiger.challus.controller;


import com.dogtiger.challus.dto.SigninReqDto;
import com.dogtiger.challus.dto.SignupReqDto;
import com.dogtiger.challus.service.AccountService;
import com.dogtiger.challus.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AccountService accountService;
    private final AuthService authService;

    @PostMapping("/api/auth/duplicate/{email}")
    public ResponseEntity<?> checkEmailDuplicate(@PathVariable String email){

        boolean isDuplicate = accountService.checkEmailDuplicate(email);

            return ResponseEntity.ok().body(isDuplicate);
    }

    @PostMapping("/api/auth/sign-up")
    public ResponseEntity<?> signUp(@RequestBody SignupReqDto signupReqDto, BindingResult bindingResult) {
        return ResponseEntity.ok(authService.signup(signupReqDto));
    }

    @PostMapping("/auth/sign-in")
    public ResponseEntity<?> signin(@RequestBody SigninReqDto signinReqDto) {
        return ResponseEntity.ok(authService.signin(signinReqDto));
    }
}