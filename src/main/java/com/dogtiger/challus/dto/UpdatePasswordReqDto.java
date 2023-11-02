package com.dogtiger.challus.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UpdatePasswordReqDto {

    @Email
    private String email;
    @NotBlank
    private String newPassword;
    @NotBlank
    private String checkNewPassword;
}
