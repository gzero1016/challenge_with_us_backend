package com.dogtiger.challus.service;

import com.dogtiger.challus.dto.IntroReqDto;
import com.dogtiger.challus.dto.UpdateNicknameReqDto;
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