package com.dogtiger.challus.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {

    private int noticeId;
    private String noticeTitle;
    private String noticeContent;
    private int userId;
    private LocalDateTime noticeDate;
}
