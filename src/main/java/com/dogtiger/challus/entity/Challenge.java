package com.dogtiger.challus.entity;

import com.dogtiger.challus.dto.ApprovedChallengesRespDto;
import com.dogtiger.challus.dto.ChallengeListRespDto;
import com.dogtiger.challus.dto.GetChallengeRespDto;
import com.dogtiger.challus.dto.GetChallengersRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Challenge {
    private int challengeId;
    private int userId;
    private String challengeName;
    private int challengeLayout;
    private String introduction;
    private String isOpen;
    private String isApplicable;
    private LocalDate startDate;
    private LocalDate endDate;
    private String categoryName;
    private String name;
    private int challengeLikeCount;

    private ChallengeApplication challengeApplication;

    public ChallengeListRespDto toChallengeListDto() {
        return ChallengeListRespDto.builder()
                .challengeId(challengeId)
                .challengeName(challengeName)
                .categoryName(categoryName)
                .isOpen(isOpen)
                .isApplicable(isApplicable)
                .userId(userId)
                .layout(challengeLayout)
                .introduction(introduction)
                .endDate(endDate.format(DateTimeFormatter.ISO_DATE))
                .name(name)
                .startDate(startDate.format(DateTimeFormatter.ISO_DATE))
                .likeCount(challengeLikeCount)
                .build();
    }

    public GetChallengeRespDto toChallengeDto() {
        GetChallengeRespDto getChallengeRespDto = GetChallengeRespDto.builder()
                .challengeId(challengeId)
                .userId(userId)
                .challengeName(challengeName)
                .layout(challengeLayout)
                .introduction(introduction)
                .isOpen(isOpen)
                .isApplicable(isApplicable)
                .startDate(startDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .categoryName(categoryName)
                .name(name)
                .challengeLikeCount(challengeLikeCount)
                .build();

        if(endDate != null) {
            getChallengeRespDto.setEndDate(endDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }else {
            endDate = null;
        }
        return getChallengeRespDto;
    }

    public ApprovedChallengesRespDto toApprovedChallengesRespDto() {
        return ApprovedChallengesRespDto.builder()
                .challengeId(challengeId)
                .challengeName(challengeName)
                .build();
    }
}
