package com.dogtiger.challus.entity;

import com.dogtiger.challus.dto.GetAdminUserResDto;
import com.dogtiger.challus.dto.GetChallengersRespDto;
import com.dogtiger.challus.dto.PrincipalResDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int userId;
    private String email;
    private String name;
    private String phone;
    private String nickname;
    private String password;
    private int point;
    private String intro;
    private String membership;
    private int isAdmin;
    private String oauth2Id;
    private String profileUrl;
    private int enabled;
    private LocalDateTime datetime;
    private int isResign;

    private Challenge challenge;

    public PrincipalResDto toPrincipalResDto() {
        return PrincipalResDto.builder()
                .userId(userId)
                .email(email)
                .name(name)
                .phone(phone)
                .nickname(nickname)
                .point(point)
                .intro(intro)
                .membership(membership)
                .isAdmin(isAdmin)
                .oauth2Id(oauth2Id)
                .profileUrl(profileUrl)
                .enabled(enabled)
                .datetime(datetime)
                .isResign(isResign)
                .build();
    }

    public GetAdminUserResDto toAdminUserResDto() {
        return GetAdminUserResDto.builder()
                .userId(userId)
                .email(email)
                .name(name)
                .phone(phone)
                .nickname(nickname)
                .point(point)
                .intro(intro)
                .membership(membership)
                .isAdmin(isAdmin)
                .oauth2Id(oauth2Id)
                .profileUrl(profileUrl)
                .enabled(enabled)
                .datetime(datetime)
                .isResign(isResign)
                .build();
    }
}