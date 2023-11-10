package com.dogtiger.challus.entity;


import com.dogtiger.challus.dto.GetChallengeRespDto;
import com.dogtiger.challus.dto.NoticeGetRespDto;
import com.dogtiger.challus.dto.NoticeListRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notice {
    private int noticeId;
    private String noticeTitle;
    private String noticeContent;
    private int userId;
    private LocalDateTime noticeDate;

    private User user;

    public NoticeListRespDto noticeListRespDto() {
        return NoticeListRespDto.builder()
                .noticeId(noticeId)
                .noticeTitle(noticeTitle)
                .nickname(user.getNickname())
                .noticeDate(noticeDate.format(DateTimeFormatter.ISO_DATE))
                .build();
    }
    public NoticeGetRespDto toNoticeDto() {
        return NoticeGetRespDto.builder()
                .noticeId(noticeId)
                .noticeTitle(noticeTitle)
                .noticeContent(noticeContent)
                .nickname(user.getNickname())
                .noticeDate(noticeDate.format(DateTimeFormatter.ofPattern("MM월dd일 HH시mm분")))
                .build();
    }
}
