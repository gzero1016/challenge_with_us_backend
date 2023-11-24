package com.dogtiger.challus.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticeGetRespDto {
    private int noticeId;
    private String noticeTitle;
    private String noticeContent;
    private String nickname;
    private String noticeDate;

}
