package com.dogtiger.challus.dto;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CommentResDto {
    private int commentId;
    private int feedId;
    private int userId;
    private String commentContent;
    private String commentDatetime;

    private String userNickname;
}