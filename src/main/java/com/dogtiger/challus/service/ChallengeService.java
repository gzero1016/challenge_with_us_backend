package com.dogtiger.challus.service;

import com.dogtiger.challus.dto.*;
import com.dogtiger.challus.entity.Challenge;
import com.dogtiger.challus.entity.ChallengeApplication;
import com.dogtiger.challus.entity.Letter;
import com.dogtiger.challus.entity.User;
import com.dogtiger.challus.exception.InvalidDateRangeException;
import com.dogtiger.challus.repository.ChallengeMapper;
import com.dogtiger.challus.security.PrincipalUser;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChallengeService {
    private final ChallengeMapper challengeMapper;

    public boolean saveChallenge(ChallengeCreateReqDto challengeCreateReqDto) throws InvalidDateRangeException {
        LocalDate startDate = challengeCreateReqDto.getStartDate().toLocalDate();
        LocalDate endDate = challengeCreateReqDto.getEndDate().toLocalDate();

        if (startDate.compareTo(endDate) > 0) {
            throw new InvalidDateRangeException("시작 날짜가 마감 날짜보다 미래 시점에 있습니다.");
        }

        if (startDate.compareTo(LocalDate.now()) < 0) {
            throw new InvalidDateRangeException("시작 날짜가 현재보다 과거 시점에 있습니다.");
        }

        return challengeMapper.saveChallenge(challengeCreateReqDto.toChallengeEntity()) > 0;
    }

    public GetChallengeRespDto getChallenge(int challengeId) {
        return challengeMapper.getChallengeByChallengeId(challengeId).toChallengeDto();
    }

    public List<ChallengeListRespDto> getChallengeList(int page, SearchChallengeListReqDto searchChallengeListReqDto) {
        int index = (page - 1) * 30;
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("index", index);
        paramsMap.put("optionName", searchChallengeListReqDto.getOptionName());
        paramsMap.put("searchValue", searchChallengeListReqDto.getSearchValue());
        paramsMap.put("sort", searchChallengeListReqDto.getSort());
        List<Challenge> challenges = challengeMapper.getChallengeList(paramsMap);

        return challenges.stream().map(Challenge::toChallengeListDto).collect(Collectors.toList());
    }

    public int getChallengeCount(SearchChallengeListReqDto searchChallengeListReqDto) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("optionName", searchChallengeListReqDto.getOptionName());
        paramsMap.put("searchValue", searchChallengeListReqDto.getSearchValue());

        return challengeMapper.getChallengeCount(paramsMap);
    }

    public int getLikeState (int challengeId) {
        return challengeMapper.getLikeState(challengeId);
    }

    public Boolean getUserLikeState (ChallengeLikeReqDto challengeLikeReqDto){
        return challengeMapper.getUserLikeState(challengeLikeReqDto.toChallengeEntity()) > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean insertLike (ChallengeLikeReqDto challengeLikeReqDto){
        return challengeMapper.insertLike(challengeLikeReqDto.toChallengeEntity()) > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean cancelLike (ChallengeLikeReqDto challengeLikeReqDto){
        return challengeMapper.cancelLike(challengeLikeReqDto.toChallengeEntity()) > 0;
    }

    public boolean challengeDelete (int challengeId) {
        return challengeMapper.challengeDelete(challengeId) > 0;
    }

    public boolean getChallengeStatus(int challengeId){
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getUser().getUserId();
        return challengeMapper.getChallengeStatus(challengeId, userId) > 0;
    }

    public boolean getChallengeAtmospher(int challengeId){
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getUser().getUserId();
        return challengeMapper.getChallengeAtmospher(challengeId, userId) > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean challengeApplicable(int challengeId){
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getUser().getUserId();
        return challengeMapper.challengeApplicable(challengeId, userId) > 0;
    }

    public List<GetChallengersRespDto> getChallengers(int challengeId) {
        return challengeMapper
                .getChallengersByChallengeId(challengeId)
                .stream()
                .map(ChallengeApplication::toChallengersDto)
                .collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean deleteChallenger (int challengeId, int userId){
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int myUserId = principalUser.getUser().getUserId();
        if(myUserId == challengeMapper.getChallengeByChallengeId(challengeId).getUserId()) {
            return challengeMapper.deleteChallenger(challengeId, userId) > 0;
        }
        return false;
    }

    public boolean challengeApproval(ChallengeApplicableReqDto challengeApplicableReqDto) {
        return challengeMapper.challengeApproval(challengeApplicableReqDto.toChallengeApplicationEntity()) > 0;
    }

    public boolean challengeRefusal(ChallengeApplicableReqDto challengeApplicableReqDto) {
        return challengeMapper.challengeRefusal(challengeApplicableReqDto.toChallengeApplicationEntity()) > 0;
    }

    public boolean challengeStop(int challengeId) {
        return challengeMapper.challengeStop(challengeId) > 0;
    }

    public boolean challengeHidden(int challengeId) {
        return challengeMapper.challengeHidden(challengeId) > 0;
    }

    public List<Map<String, Object>> getChallengesCount() {
        List<Map<String, Object>> result = challengeMapper.getAdminChallengersCount();
        for (Map<String, Object> entry : result) {
        }
        return result;
    }

    public List<Map<String, Object>> getChallengeCompletedCount() {
        List<Map<String, Object>> result = challengeMapper.getChallengeCompletedCount();
        for (Map<String, Object> entry : result) {
        }
        return result;
    }

    public List<Map<String, Object>> getChallengeDeletedCount() {
        List<Map<String, Object>> result = challengeMapper.getChallengeDeletedCount();
        for (Map<String, Object> entry : result) {
        }
        return result;
    }

    public int getChallengeProgress(int challengeId) {
        return challengeMapper.getChallengeProgress(challengeId);
    }

    public boolean saveFeedPoint(int challengeUserId) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getUser().getUserId();

        return challengeMapper.saveFeedPoint(userId, challengeUserId) > 0;
    }
}