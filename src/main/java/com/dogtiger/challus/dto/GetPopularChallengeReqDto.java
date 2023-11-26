package com.dogtiger.challus.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetPopularChallengeReqDto {
    private String year;
    private String month;
    private String date;
}
