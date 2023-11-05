package com.dogtiger.challus.dto;

import com.dogtiger.challus.entity.User;
import lombok.Data;

@Data
public class UpdateProfileDetailReqDto {
    private int userId;
    private String nickname;
    private String profileUrl;

    public User toUserEntity() {
        return User.builder()
                .userId(userId)
                .nickname(nickname)
                .profileUrl(profileUrl)
                .build();
    }
}
