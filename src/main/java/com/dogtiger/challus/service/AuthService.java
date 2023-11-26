package com.dogtiger.challus.service;

import com.dogtiger.challus.dto.*;
import com.dogtiger.challus.entity.Feed;
import com.dogtiger.challus.entity.User;
import com.dogtiger.challus.jwt.JwtProvider;
import com.dogtiger.challus.repository.UserMapper;
import com.dogtiger.challus.security.PrincipalProvider;
import com.dogtiger.challus.security.PrincipalUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    private final PrincipalProvider principalProvider;
    private final JwtProvider jwtProvider;

    public boolean signup(SignupReqDto signupReqDto) {
        User user = signupReqDto.toUserEntity(passwordEncoder);
        return userMapper.saveUser(user) > 0;
    }

    public String signin(SigninReqDto signinReqDto) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(signinReqDto.getEmail(), signinReqDto.getPassword());

        try {
            Authentication authentication = principalProvider.authenticate(authenticationToken);

            if(authentication.isAuthenticated()){
                String oauth2Id = null;
                return jwtProvider.generateToken(authentication, oauth2Id);
            }else {
                return null;
            }
        }catch (AuthenticationException e) {
            return null;
        }
    }

    public List<Map<String, Object>> getMembersCount() {
        List<Map<String, Object>> result = userMapper.getMembersCount();
        for (Map<String, Object> entry : result) {
        }
        return result;
    }


    public List<GetAdminUserResDto> adminListGet() {
        List<User> adminUserList = userMapper.getIsAdminUser();
        return adminUserList.stream().map(User::toAdminUserResDto).collect(Collectors.toList());
    }
}