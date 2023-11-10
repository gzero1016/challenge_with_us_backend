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
    private LocalDate dateTime;
}
