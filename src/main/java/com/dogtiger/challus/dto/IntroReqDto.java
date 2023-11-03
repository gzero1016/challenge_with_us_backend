package com.dogtiger.challus.dto;

import com.dogtiger.challus.entity.User;
import lombok.Data;

@Data
public class IntroReqDto {
    private String intro;
    private String nickname;

    public User toUserEntity() {
        return User.builder()
                .nickname(nickname)
                .intro(intro)
                .build();
    }
}
