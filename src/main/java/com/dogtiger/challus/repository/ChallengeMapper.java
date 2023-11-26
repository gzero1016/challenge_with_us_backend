package com.dogtiger.challus.repository;

import com.dogtiger.challus.dto.GetPopularChallengeReqDto;
import com.dogtiger.challus.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface ChallengeMapper {
    public int saveChallenge(Challenge challenge);
    public Challenge getChallengeByChallengeId(int challengeId);
    public List<Challenge> getChallenges();
    public List<Challenge> getChallengeList(Map<String, Object> paramsMap);
    public Challenge getPopularChallenge(GetPopularChallengeReqDto getPopularChallengeReqDto);
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
    public List<Challenge> getApprovedEndChallengesByUserId(int userId);
    public int challengeApproval(ChallengeApplication challengeApplication);
    public int challengeRefusal(ChallengeApplication challengeApplication);
    public int findReceiverUserId(int challengeId);
    public int challengeStop(int challengeId);
    public int challengeHidden(int challengeId);
    public List<Map<String, Object>> getAdminChallengersCount();
    public List<Map<String, Object>> getChallengeCompletedCount();
    public List<Map<String, Object>> getChallengeDeletedCount();
    public int getChallengeProgress(int challengeId);
    public int saveFeedPoint(int userId, int challengeUserId);
}
