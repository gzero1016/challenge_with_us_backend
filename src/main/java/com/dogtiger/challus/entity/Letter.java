package com.dogtiger.challus.entity;

import com.dogtiger.challus.dto.LettersResDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Letter {
    private int letterId;
    private int senderUserId;
    private int receiverUserId;
    private String title;
    private String content;
    private LocalDateTime sendDateTime;
    private int isRead;
    private int letterType;
    private String targetUrl;

    public LettersResDto toLettersResDto() {
        return LettersResDto.builder()
                .letterId(letterId)
                .senderUserId(senderUserId)
                .receiverUserId(receiverUserId)
                .title(title)
                .content(content)
                .sendDateTime(sendDateTime.format(DateTimeFormatter.ofPattern("MM월dd일 HH시mm분")))
                .isRead(isRead)
                .letterType(letterType)
                .targetUrl(targetUrl)
                .build();
    }
}