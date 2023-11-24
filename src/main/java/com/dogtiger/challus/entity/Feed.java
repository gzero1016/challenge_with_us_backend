package com.dogtiger.challus.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Feed {
    private int feedId;
    private int userId;
    private int challengeId;
    private String categoryName;
    private String feedContent;
    private int stopWatch;
    private String img;
<<<<<<< Updated upstream
    private LocalDate dateTime;
    private int challengeLayout;
    private int layout;
=======
    private LocalDateTime dateTime;
    private LocalDateTime updatetime;
    private String nickname;
    private String profileUrl;
    private int feedLike;

    private User user;

    public FeedResDto toFeedResDto(){
        return FeedResDto
                .builder()
                .feedId(feedId)
                .challengeLayout(challengeLayout)
                .layout(layout)
                .userId(userId)
                .challengeId(challengeId)
                .challengeName(challengeName)
                .categoryName(categoryName)
                .feedContent(feedContent)
                .stopWatch(stopWatch)
                .img(img)
                .nickname(nickname)
                .profileUrl(profileUrl)
                .dateTime(dateTime)
                .updatetime(updatetime)
                .likeCount(feedLike)
                .build();
    }
>>>>>>> Stashed changes
}
