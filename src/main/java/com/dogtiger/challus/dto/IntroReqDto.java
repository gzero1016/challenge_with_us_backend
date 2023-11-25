package com.dogtiger.challus.dto;

import com.dogtiger.challus.entity.User;
import lombok.Data;

@Data
public class IntroReqDto {
    private String intro;
    private int userId;

    public User toUserEntity() {
        return User.builder()
                .userId(userId)
                .intro(intro)
                .build();
    }
}
