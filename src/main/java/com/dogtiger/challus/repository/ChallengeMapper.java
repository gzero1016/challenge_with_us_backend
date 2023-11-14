package com.dogtiger.challus.repository;

import com.dogtiger.challus.entity.Challenge;
import com.dogtiger.challus.entity.ChallengeApplication;
import com.dogtiger.challus.entity.User;
import com.dogtiger.challus.entity.Letter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ChallengeMapper {
    public int saveChallenge(Challenge challenge);
    public Challenge getChallengeByChallengeId(int challengeId);
    public List<Challenge> getChallenges();
    public List<Challenge> getChallengeList(Map<String, Object> paramsMap);
    public int getChallengeCount(Map<String, Object> paramsMap);
    public int getLikeState(int challengeId);
    public int getUserLikeState(Challenge challenge);
    public int insertLike(Challenge challenge);
    public int cancelLike(Challenge challenge);
    public int challengeDelete(int challengeId);
    public int getChallengeStatus(int challengeId, int userId);
    public int getChallengeAtmospher(int challengeId, int userId);
    public int challengeApplicable(int challengeId, int userId);
    public List<ChallengeApplication> getChallengersByChallengeId(int challengeId);
    public int deleteChallenger(int challengeId, int userId);
    public List<Challenge> getApprovedChallengesByUserId(int userId);
    public int challengeApproval(ChallengeApplication challengeApplication);
    public int challengeRefusal(ChallengeApplication challengeApplication);
    public int findReceiverUserId(int challengeId);
}
