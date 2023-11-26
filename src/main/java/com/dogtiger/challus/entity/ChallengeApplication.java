package com.dogtiger.challus.entity;

import com.dogtiger.challus.dto.ApprovedChallengesRespDto;
import com.dogtiger.challus.dto.GetChallengersRespDto;
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

    private User user;


    public GetChallengersRespDto toChallengersDto() {
        return GetChallengersRespDto.builder()
                .userId(userId)
                .nickname(user.getNickname())
                .profileUrl(user.getProfileUrl())
                .build();
    }
}
