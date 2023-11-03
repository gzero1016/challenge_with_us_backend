package com.dogtiger.challus.dto;

import com.dogtiger.challus.entity.Challenge;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ChallengeCreateReqDto {
    private String title;
    private String isPrivate;
    private String isApplicable;
    private LocalDate startDate;
    private LocalDate endDate;
    private int userId;

    public Challenge toChallengeEntity() {
        return Challenge.builder()
                .challengeName(title)
                .isOpen(isPrivate)
                .isApplicable(isApplicable)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}
