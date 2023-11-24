package com.dogtiger.challus.service;

import com.dogtiger.challus.dto.FeedResDto;
import com.dogtiger.challus.dto.IntroReqDto;
import com.dogtiger.challus.dto.UpdateProfileDetailReqDto;
import com.dogtiger.challus.dto.ApprovedChallengesRespDto;
import com.dogtiger.challus.entity.Feed;
import com.dogtiger.challus.jwt.JwtProvider;
import com.dogtiger.challus.repository.ChallengeMapper;
import com.dogtiger.challus.repository.UserMapper;
import com.dogtiger.challus.security.PrincipalUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public void deleteUser(int targetUserId) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int currentUserId = principalUser.getUser().getUserId();

        if (!hasDeletePermission(targetUserId, currentUserId)) {
            throw new AccessDeniedException("You do not have permission to delete this user");
        }

        userMapper.deleteUser(targetUserId);
    }

    private boolean hasDeletePermission(int targetUserId, int currentUserId) {
        if(currentUserId == 1 || currentUserId == 2) {
            return true;
        }else if(targetUserId == currentUserId){
            return true;
        }

        return false;
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

    public List<ApprovedChallengesRespDto> getMyEndChallenge() {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getUser().getUserId();

        List<ApprovedChallengesRespDto> approvedChallengesRespDtos = new ArrayList<>();

        challengeMapper.getApprovedEndChallengesByUserId(userId).forEach(challengesApplication -> {
            approvedChallengesRespDtos.add(challengesApplication.toApprovedChallengesRespDto());
        });
        return approvedChallengesRespDtos;
    }

    public int getProgress(int challengeId) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getUser().getUserId();

        return userMapper.getProgress(challengeId, userId);
    }

    public List<FeedResDto> getChallengeFeeds(int challengeId) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getUser().getUserId();

        List<Feed> feedList = userMapper.getChallengeFeeds(challengeId, userId);

        return feedList.stream().map(Feed::toFeedResDto).collect(Collectors.toList());
    }

}
