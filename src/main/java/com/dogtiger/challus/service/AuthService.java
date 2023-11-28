package com.dogtiger.challus.service;

import com.dogtiger.challus.dto.*;
import com.dogtiger.challus.entity.Feed;
import com.dogtiger.challus.entity.Letter;
import com.dogtiger.challus.entity.User;
import com.dogtiger.challus.enums.StoreItem;
import com.dogtiger.challus.jwt.JwtProvider;
import com.dogtiger.challus.repository.LetterMapper;
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
import org.springframework.transaction.annotation.Transactional;
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
    private final LetterMapper letterMapper;

    @Transactional(rollbackFor = Exception.class)
    public boolean signup(SignupReqDto signupReqDto) {
        User user = signupReqDto.toUserEntity(passwordEncoder);

        boolean result = userMapper.saveUser(user) > 0;

        letterMapper.insertLetter(Letter.builder()
                .senderUserId(1)
                .receiverUserId(user.getUserId())
                .letterTitle("인사")
                .title("새로운 도전자여 환영한다")
                .content("챌어스 이용 방법을 필독해주세요")
                .letterType(8)
                .targetUrl("http://localhost:3000/notice/3")
                .targetId(3)
                .build());

        return result;
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