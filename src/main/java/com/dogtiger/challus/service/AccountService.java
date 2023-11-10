package com.dogtiger.challus.service;

import com.dogtiger.challus.dto.IntroReqDto;
import com.dogtiger.challus.dto.UpdateProfileDetailReqDto;
import com.dogtiger.challus.dto.ApprovedChallengesRespDto;
import com.dogtiger.challus.jwt.JwtProvider;
import com.dogtiger.challus.repository.ChallengeMapper;
import com.dogtiger.challus.repository.UserMapper;
import com.dogtiger.challus.security.PrincipalUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final UserMapper userMapper;
    private final ChallengeMapper challengeMapper;
    private final JwtProvider jwtProvider;

    public boolean updateMypageDetail(UpdateProfileDetailReqDto updateProfileDetailReqDto) {
        return userMapper.updateMypageDetail(updateProfileDetailReqDto.toUserEntity()) > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean deleteUser(int userId) {
        return userMapper.deleteUser(userId) > 0;
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

    public List<ApprovedChallengesRespDto> getMyChallenges() {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getUser().getUserId();

        List<ApprovedChallengesRespDto> approvedChallengesRespDtos = new ArrayList<>();

        challengeMapper.getApprovedChallengesByUserId(userId).forEach(challengesApplication -> {
            approvedChallengesRespDtos.add(challengesApplication.toApprovedChallengesRespDto());
        });
        return approvedChallengesRespDtos;
    }

}
