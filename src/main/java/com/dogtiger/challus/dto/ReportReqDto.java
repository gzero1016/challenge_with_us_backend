package com.dogtiger.challus.dto;

import com.dogtiger.challus.entity.Letter;
import lombok.Data;

@Data
public class ReportReqDto {
    private int senderUserId;
    private int receiverUserId;
    private int feedId;
    private int challengeId;
    private String content;

    public Letter toLetterEntity() {
        return Letter.builder()
                .challengeId(challengeId)
                .content(content)
                .senderUserId(senderUserId)
                .receiverUserId(receiverUserId)
                .targetId(challengeId)
                .build();
    }
}
