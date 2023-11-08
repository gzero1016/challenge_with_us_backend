package com.dogtiger.challus.dto;

import com.dogtiger.challus.entity.Challenge;
import lombok.Data;

@Data
public class ChallengeLikeReqDto {
    private int challengeId;
    private int userId;

    public Challenge toChallengeEntity() {
        return Challenge.builder()
                .challengeId(challengeId)
                .userId(userId)
                .build();
    }
}
