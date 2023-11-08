package com.dogtiger.challus.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoticeListRespDto {
    private int noticeId;
    private String noticeTitle;
    private String nickname;
    private String noticeDate;
}
