package com.dogtiger.challus.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChallengeListRespDto {
    private int challengeId;
    private String title;
    private String categoryname;
    private String startDate;
    private int likeCount;
}
