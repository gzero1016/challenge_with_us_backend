package com.dogtiger.challus.entity;

import com.dogtiger.challus.dto.AttendanceReqDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Stamp {
    private int stampId;
    private int userId;
    private String attendance;

    private User user;

    public AttendanceReqDto toAttendanceDto() {
        return AttendanceReqDto.builder()
                .userId(userId)
                .attendance(attendance)
                .build();
    }
}
