package com.dogtiger.challus.service;

import com.dogtiger.challus.dto.ChallengeCreateReqDto;
import com.dogtiger.challus.dto.GetChallengeRespDto;
import com.dogtiger.challus.repository.ChallengeMapper;
import com.dogtiger.challus.security.PrincipalUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ChallengeService {
    private final ChallengeMapper challengeMapper;

    public boolean saveChallenge(ChallengeCreateReqDto challengeCreateReqDto) {
        return challengeMapper.saveChallenge(challengeCreateReqDto.toChallengeEntity()) > 0;
    }

    public GetChallengeRespDto getChallenge(int challengeId) {
        return challengeMapper.getChallengeByChallengeId(challengeId).toChallengeDto();
    }

    public boolean getLikeState(int challengeId) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("challengeId", challengeId);
        paramsMap.put("userId", SecurityContextHolder.getContext().getAuthentication().getName());
        return challengeMapper.getLikeState(paramsMap) > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean insertLike(int challengeId) {
        int userId = ((PrincipalUser)SecurityContextHolder.getContext().getAuthentication()).getUser().getUserId();
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("challengeId", challengeId);
        paramsMap.put("userId", userId);
        return challengeMapper.insertLike(paramsMap) > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean cancelLike(int challengeId) {
        int userId = ((PrincipalUser)SecurityContextHolder.getContext().getAuthentication()).getUser().getUserId();
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("challengeId", challengeId);
        paramsMap.put("userId", userId);
        return challengeMapper.cancelLike(paramsMap) > 0;
    }
}
