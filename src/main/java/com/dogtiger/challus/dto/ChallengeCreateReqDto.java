package com.dogtiger.challus.dto;

import com.dogtiger.challus.entity.Challenge;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ChallengeCreateReqDto {
    private String challengeName;
    private String introduction;
    private String isOpen;
    private String isApplicable;
    private LocalDate startDate;
    private LocalDate endDate;
    private int layout;
    private int userId;
    private String categoryName;

    public Challenge toChallengeEntity() {
        return Challenge.builder()
                .challengeName(challengeName)
                .introduction(introduction)
                .isOpen(isOpen)
                .isApplicable(isApplicable)
                .startDate(startDate)
                .endDate(endDate)
                .userId(userId)
                .challengeLayout(layout)
                .categoryName(categoryName)
                .build();
    }
}
