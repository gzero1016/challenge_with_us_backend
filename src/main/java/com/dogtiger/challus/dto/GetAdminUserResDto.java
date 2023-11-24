package com.dogtiger.challus.dto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class GetAdminUserResDto {
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
    private int enabled;
    private LocalDateTime datetime;
    private int isResign;
}