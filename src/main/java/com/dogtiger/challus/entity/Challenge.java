package com.dogtiger.challus.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Challenge {
    private int challengeId;
    private int userId;
    private String challengeName;
    private int layout;
    private String introduction;
    private String isOpen;
    private String isApplicable;
    private LocalDate startDate;
    private LocalDate endDate;
    private String categoryName;
}
