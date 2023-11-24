package com.dogtiger.challus.dto;

import com.dogtiger.challus.entity.Notice;
import lombok.Data;

@Data
public class NoticeEditReqDto {

    private String title;
    private String content;

    public Notice toNoticeEntity(int userId) {
        return Notice.builder()
                .noticeTitle(title)
                .noticeContent(content)
                .userId(userId)
                .build();
    }
}
