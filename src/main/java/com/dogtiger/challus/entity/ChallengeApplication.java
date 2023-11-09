package com.dogtiger.challus.entity;

import com.dogtiger.challus.dto.ApprovedChallengesRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChallengeApplication {
    private int challengeApplicationId;
    private int challengeId;
    private int userId;
    private int acceptState;
}
