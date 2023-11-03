package com.dogtiger.challus.entity;

import com.dogtiger.challus.dto.PrincipalResDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private int userId;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String nickname;
    private int point;
    private String intro;
    private String membership;
    private int isAdmin;
    private String oauth2Id;
    private String profileUrl;

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
                .build();
    }

}