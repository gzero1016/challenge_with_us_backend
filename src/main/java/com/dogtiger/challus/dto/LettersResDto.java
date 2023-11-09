package com.dogtiger.challus.dto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class LettersResDto {
    private int letterId;
    private int senderUserId;
    private int receiverUserId;
    private String title;
    private String content;
    private String sendDateTime;
    private int isRead;
    private int letterType;
    private String targetUrl;
}