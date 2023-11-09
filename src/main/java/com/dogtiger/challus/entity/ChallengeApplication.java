package com.dogtiger.challus.entity;

import com.dogtiger.challus.dto.ApprovedChallengesRespDto;
import com.dogtiger.challus.dto.GetChallengersRespDto;
import lombok.Data;

@Data
public class ChallengeApplication {
    private int challengeApplicationId;
    private int challengeId;
    private int userId;
    private int acceptState;

    private User user;


    public GetChallengersRespDto toChallengersDto() {
        return GetChallengersRespDto.builder()
                .userId(userId)
                .nickname(user.getNickname())
                .build();
    }
}
