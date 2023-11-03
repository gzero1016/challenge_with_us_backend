package com.dogtiger.challus.service;

import com.dogtiger.challus.dto.IntroReqDto;
import com.dogtiger.challus.dto.UpdateNicknameReqDto;
import com.dogtiger.challus.dto.UpdatePasswordReqDto;
import com.dogtiger.challus.jwt.JwtProvider;
import com.dogtiger.challus.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

    public boolean checkEmailDuplicate(String email){
        return userMapper.findUserByEmail(email) != null;
    }

    public boolean updateIntro(IntroReqDto introReqDto) {
        return userMapper.updateIntro(introReqDto.toUserEntity()) > 0;
    }

    public boolean saveIntro(IntroReqDto introReqDto) {
        return userMapper.saveIntro(introReqDto.toUserEntity()) > 0;
    }

    public String getIntro(IntroReqDto introReqDto) {
        return userMapper.getIntro(introReqDto.toUserEntity());
    }

}
