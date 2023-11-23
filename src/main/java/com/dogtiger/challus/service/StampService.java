package com.dogtiger.challus.service;

import com.dogtiger.challus.dto.AttendanceReqDto;
import com.dogtiger.challus.entity.Challenge;
import com.dogtiger.challus.entity.Stamp;
import com.dogtiger.challus.repository.StampMapper;
import com.dogtiger.challus.security.PrincipalUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StampService {

    private final StampMapper stampMapper;

    public boolean saveAttendance(AttendanceReqDto attendanceReqDto) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getUser().getUserId();
        attendanceReqDto.setUserId(userId);

        return stampMapper.saveAttendance(attendanceReqDto.toStamp()) > 0;
    }

    public List<AttendanceReqDto> getAttendances() {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getUser().getUserId();
        List<Stamp> stamps = stampMapper.getAttendances(userId);

        return stamps.stream().map(Stamp::toAttendanceDto).collect(Collectors.toList());
    }
}
