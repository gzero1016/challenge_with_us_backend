package com.dogtiger.challus.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApprovedChallengesRespDto {
    private int challengeId;
    private String challengeName;
}
