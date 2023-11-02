package com.dogtiger.challus.dto;

import com.dogtiger.challus.entity.User;
import lombok.Data;

@Data
public class IntroReqDto {
    private int userId;
    private String intro;

    public User toUserEntity() {
        return User.builder()
                .userId(userId)
                .intro(intro)
                .build();
    }
}
