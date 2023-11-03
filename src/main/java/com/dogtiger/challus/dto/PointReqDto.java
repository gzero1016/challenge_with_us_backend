package com.dogtiger.challus.dto;

import com.dogtiger.challus.entity.Point;
import lombok.Data;

@Data
public class PointReqDto {
    private int userId;
    private int point;

    public Point toPointEntity() {
        return Point.builder()
                .userId(userId)
                .point(point)
                .build();
    }
}
