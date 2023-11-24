package com.dogtiger.challus.dto;

import com.dogtiger.challus.entity.Stamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceReqDto {
    private int userId;
    private String attendance;

    public Stamp toStamp() {
        return Stamp.builder()
                .userId(userId)
                .attendance(attendance)
                .build();
    }
}
