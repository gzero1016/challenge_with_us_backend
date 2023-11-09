package com.dogtiger.challus.dto;

import com.dogtiger.challus.entity.Letter;
import lombok.Data;

@Data
public class LetterReqDto {
    private int senderUserId;
    private int receiverUserId;
    private String title;
    private String content;
    private String targetUrl;

    public Letter toLetterEntity() {
        return Letter.builder()
                .senderUserId(senderUserId)
                .receiverUserId(receiverUserId)
                .title(title)
                .content(content)
                .targetUrl(targetUrl)
                .build();
    }
}
