package com.dogtiger.challus.dto;

import com.dogtiger.challus.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyCommentReqDto {
    private String commentContent;

    public Comment toComment(Comment targetComment) {
        return Comment.builder()
                .commentId(targetComment.getCommentId())
                .feedId(targetComment.getFeedId())
                .userId(targetComment.getUserId())
                .commentContent(commentContent)
                .commentDatetime(targetComment.getCommentDatetime())
                .build();
    }
}