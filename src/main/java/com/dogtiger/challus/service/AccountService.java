package com.dogtiger.challus.service;

import com.dogtiger.challus.dto.UpdateNicknameReqDto;
import com.dogtiger.challus.dto.UpdatePasswordReqDto;
import com.dogtiger.challus.entity.User;
import com.dogtiger.challus.jwt.JwtProvider;
import com.dogtiger.challus.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final UserMapper userMapper;
    private final JwtProvider jwtProvider;
    private final BCryptPasswordEncoder passwordEncoder;

    public boolean updatePassword(UpdatePasswordReqDto updatePasswordReqDto) {

//        User user;
//
//        user.setPassword(updatePasswordReqDto.getNewPassword());
        return userMapper.updatePassword(updatePasswordReqDto.toUserEntity()) > 0;
    }

    public boolean updateNickname(UpdateNicknameReqDto updateNicknameReqDto) {

        return userMapper.updateNickname(updateNicknameReqDto.toUserEntity()) > 0;
    }
}
