package com.dogtiger.challus.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetChallengeRespDto {
    private int challengeId;
    private int userId;
    private String challengeName;
    private int layout;
    private String introduction;
    private String isOpen;
    private String isApplicable;
    private String startDate;
    private String endDate;
    private String categoryName;
    private String name;
    private int challengeLikeCount;
    private int challenger;
}
