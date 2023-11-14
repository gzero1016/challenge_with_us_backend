package com.dogtiger.challus.dto;

import com.dogtiger.challus.entity.Feed;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommentReqDto {
    private String commentContent;
}