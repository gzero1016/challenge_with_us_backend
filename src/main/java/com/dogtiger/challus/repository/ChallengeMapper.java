package com.dogtiger.challus.repository;

import com.dogtiger.challus.entity.Challenge;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChallengeMapper {
    public int saveChallenge(Challenge challenge);
    public Challenge getChallengeByChallengeId(int challengeId);
}
