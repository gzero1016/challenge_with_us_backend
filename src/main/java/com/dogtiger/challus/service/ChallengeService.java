package com.dogtiger.challus.service;

import com.dogtiger.challus.dto.ChallengeCreateReqDto;
import com.dogtiger.challus.dto.ChallengeLikeReqDto;
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

    public int getLikeState(int challengeId) {
        return challengeMapper.getLikeState(challengeId);
    }

    public Boolean getUserLikeState(ChallengeLikeReqDto challengeLikeReqDto) {
        return challengeMapper.getUserLikeState(challengeLikeReqDto.toChallengeEntity()) > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean insertLike(ChallengeLikeReqDto challengeLikeReqDto) {
        return challengeMapper.insertLike(challengeLikeReqDto.toChallengeEntity()) > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean cancelLike(ChallengeLikeReqDto challengeLikeReqDto) {
        return challengeMapper.cancelLike(challengeLikeReqDto.toChallengeEntity()) > 0;
    }

    public boolean challengeDelete(int challengeId){
        return challengeMapper.challengeDelete(challengeId) > 0;
    }
}
