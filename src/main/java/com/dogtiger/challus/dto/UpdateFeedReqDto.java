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
    private String image;


    public Feed toUpdateFeedEntity() {
        String modifiedImage = (image != null) ? image.replace("blob:", "") : null;

        return Feed.builder()
                .feedContent(text)
                .img(modifiedImage)
                .build();
    }
}
