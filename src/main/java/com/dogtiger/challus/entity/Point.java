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
public class Point {
    private int userId;
    private int pointType;
    private int point;
    private LocalDate date;
}
