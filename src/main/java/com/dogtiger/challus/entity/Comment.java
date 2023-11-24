package com.dogtiger.challus.entity;

import com.dogtiger.challus.dto.CommentResDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    private String userNickname;

    public CommentResDto toCommentResDto() {
        return CommentResDto.builder()
                .commentId(commentId)
                .feedId(feedId)
                .userId(userId)
                .commentContent(commentContent)
                .commentDatetime(commentDatetime.format(DateTimeFormatter.ofPattern("MM월dd일 HH시mm분")))
                .userNickname(userNickname)
                .build();
    }
}
