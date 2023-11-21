package com.dogtiger.challus.dto;

import com.dogtiger.challus.entity.Letter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LetterReqDto {
    private int senderUserId;
    private int receiverUserId;
    private String title;
    private String content;
    private String targetUrl;
    private int targetId;

    public Letter toLetterEntity() {
        Letter letter = Letter.builder()
                .senderUserId(senderUserId)
                .receiverUserId(receiverUserId)
                .title(title)
                .content(content)
                .targetUrl(targetUrl)
                .targetId(targetId)
                .build();
        if(letter.getTitle().equals("챌린지 승인 완료")) {
            letter.setLetterType(3);

        }else if(letter.getTitle().equals("챌린지 승인 거부")){
            letter.setLetterType(4);

        }

        return letter;
    }
}
