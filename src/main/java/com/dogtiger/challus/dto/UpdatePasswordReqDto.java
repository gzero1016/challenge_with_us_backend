package com.dogtiger.challus.dto;

import com.dogtiger.challus.entity.User;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UpdatePasswordReqDto {
    private int userId;
    @NotBlank
    private String newPassword;
    @NotBlank
    private String checkNewPassword;

    public User toUserEntity() {
        return User.builder()
                .userId(userId)
                .password(newPassword)
                .build();
    }
}
