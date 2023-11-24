package com.dogtiger.challus.dto;

import com.dogtiger.challus.entity.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetChallengersRespDto {
    private int userId;
    private String nickname;

    public User toUserEntity() {
        return User.builder()
                .nickname(nickname)
                .build();
    }
}
