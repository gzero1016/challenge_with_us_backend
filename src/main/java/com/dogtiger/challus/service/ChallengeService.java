package com.dogtiger.challus.service;

import com.dogtiger.challus.dto.ChallengeCreateReqDto;
import com.dogtiger.challus.dto.ChallengeListRespDto;
import com.dogtiger.challus.dto.GetChallengeRespDto;
import com.dogtiger.challus.dto.SearchChallengeListReqDto;
import com.dogtiger.challus.repository.ChallengeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
}
