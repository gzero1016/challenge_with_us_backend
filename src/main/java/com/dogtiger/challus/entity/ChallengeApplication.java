package com.dogtiger.challus.entity;

import com.dogtiger.challus.dto.ApprovedChallengesRespDto;
import lombok.Data;

@Data
public class ChallengeApplication {
    private int challengeApplicationId;
    private int challengeId;
    private int userId;
    private int acceptState;
}
