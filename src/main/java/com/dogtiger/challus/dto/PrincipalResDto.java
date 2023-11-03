package com.dogtiger.challus.dto;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PrincipalResDto {
    private int userId;
    private String email;
    private String name;
    private String phone;
    private String nickname;
    private int point;
    private String intro;
    private String membership;
    private int isAdmin;
    private String oauth2Id;
    private String profileUrl;
}