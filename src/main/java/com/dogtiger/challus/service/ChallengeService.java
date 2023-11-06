package com.dogtiger.challus.service;

import com.dogtiger.challus.dto.ChallengeCreateReqDto;
import com.dogtiger.challus.dto.GetChallengeRespDto;
import com.dogtiger.challus.repository.ChallengeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
