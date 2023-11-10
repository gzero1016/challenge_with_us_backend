package com.dogtiger.challus.dto;

import com.dogtiger.challus.entity.ChallengeApplication;
import lombok.Data;

@Data
public class ChallengeApplicableReqDto {
    private int userId;
    private int challengeId;

    public ChallengeApplication toChallengeApplicationEntity() {
        return ChallengeApplication
                .builder()
                .challengeId(challengeId)
                .userId(userId)
                .build();
    }
}
