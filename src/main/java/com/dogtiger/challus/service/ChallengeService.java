package com.dogtiger.challus.service;

import com.dogtiger.challus.dto.ChallengeCreateReqDto;
import com.dogtiger.challus.dto.ChallengeListRespDto;
import com.dogtiger.challus.dto.ChallengeLikeReqDto;
import com.dogtiger.challus.dto.GetChallengeRespDto;
import com.dogtiger.challus.dto.SearchChallengeListReqDto;
import com.dogtiger.challus.repository.ChallengeMapper;
import com.dogtiger.challus.security.PrincipalUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

import java.util.ArrayList;
import java.util.List;

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


    public List<ChallengeListRespDto> getChallengeList(int page, SearchChallengeListReqDto searchChallengeListReqDto) {
        int index = (page - 1) * 10;
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("index", index);
        paramsMap.put("optionName", searchChallengeListReqDto.getOptionName());
        paramsMap.put("searchValue", searchChallengeListReqDto.getSearchValue());

        List<ChallengeListRespDto> challengeListRespDtos = new ArrayList<>();
        challengeMapper.getChallengeList(paramsMap).forEach(challenge -> {
            challengeListRespDtos.add(challenge.toChallengeListDto());
        });

        return challengeListRespDtos;
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

}
