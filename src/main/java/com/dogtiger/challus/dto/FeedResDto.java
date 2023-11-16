package com.dogtiger.challus.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Builder
public class FeedResDto {
    private int feedId;
    private int challengeLayout;
    private int layout;
    private int userId;
    private int challengeId;
    private String challengeName;
    private String categoryName;
    private String feedContent;
    private int stopWatch;
    private String img;
    private String nickname;
    private String profileUrl;
    private LocalDateTime dateTime;
    private int likeCount;
}
