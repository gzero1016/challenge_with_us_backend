package com.dogtiger.challus.controller;


import com.dogtiger.challus.dto.PasswordMatchesReqDto;
import com.dogtiger.challus.dto.SigninReqDto;
import com.dogtiger.challus.dto.SignupReqDto;
import com.dogtiger.challus.security.PrincipalUser;
import com.dogtiger.challus.service.AccountService;
import com.dogtiger.challus.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AccountService accountService;
    private final AuthService authService;
    private final BCryptPasswordEncoder passwordEncoder;

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

    @PostMapping("/api/account/checkpassword")
    public ResponseEntity<?> checkPassword(@RequestBody PasswordMatchesReqDto passwordMatchesReqDto) {
        try {
            PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            boolean passwordMatches = passwordEncoder.matches(passwordMatchesReqDto.getPassword(), principalUser.getPassword());

            if (passwordMatches) {
                return ResponseEntity.ok(true);
            } else {
                throw new AuthenticationException("비밀번호가 일치하지 않습니다.") {
                };
            }
        } catch (AuthenticationException e) {
            return ResponseEntity.ok(false);
        }
    }
}