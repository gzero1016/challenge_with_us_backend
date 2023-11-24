package com.dogtiger.challus.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApprovedChallengesRespDto {
    private int challengeId;
    private String challengeName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
