package com.dogtiger.challus.dto;

import com.dogtiger.challus.entity.Feed;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFeedReqDto {
    private String text;
    private String img;


    public Feed toUpdateFeedEntity() {

        return Feed.builder()
                .feedContent(text)
                .img(img)
                .build();
    }
}
