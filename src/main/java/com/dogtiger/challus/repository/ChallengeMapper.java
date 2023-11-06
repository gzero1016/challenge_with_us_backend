package com.dogtiger.challus.repository;

import com.dogtiger.challus.entity.Challenge;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ChallengeMapper {
    public int saveChallenge(Challenge challenge);
    public Challenge getChallengeByChallengeId(int challengeId);
    public int getLikeState(Map<String, Object> paramsMap);
    public int insertLike(Map<String, Object> paramsMap);
    public int cancelLike(Map<String, Object> paramsMap);
}
