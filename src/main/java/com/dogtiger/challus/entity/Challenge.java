package com.dogtiger.challus.entity;

import com.dogtiger.challus.dto.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

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
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String categoryName;
    private String name;
    private int challengeLikeCount;
    private int challenger;
    private int isDeadline;
    private int isHidden;

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
                .isDeadline(isDeadline)
                .isHidden(isHidden)
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
                .challenger(challenger)
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
