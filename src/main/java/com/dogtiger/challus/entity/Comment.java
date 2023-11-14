package com.dogtiger.challus.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private int commentId;
    private int feedId;
    private int userId;
    private String commentContent;
    private LocalDateTime commentDatetime;
}
