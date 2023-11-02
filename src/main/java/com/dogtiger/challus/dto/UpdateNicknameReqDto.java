package com.dogtiger.challus.dto;

import com.dogtiger.challus.entity.User;
import lombok.Data;

@Data
public class UpdateNicknameReqDto {
    private int userId;
    private String nickname;

    public User toUserEntity() {
        return User.builder()
                .userId(userId)
                .nickname(nickname)
                .build();
    }
}
