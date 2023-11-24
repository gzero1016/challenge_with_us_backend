package com.dogtiger.challus.controller;

import com.dogtiger.challus.dto.AttendanceReqDto;
import com.dogtiger.challus.service.StampService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StampController {

    private final StampService stampService;

    @PostMapping("/api/attendance")
    public ResponseEntity<?> saveAttendance(@RequestBody AttendanceReqDto attendanceReqDto) {
        return ResponseEntity.ok().body(stampService.saveAttendance(attendanceReqDto));
    }

    @GetMapping("/api/attendance")
    public ResponseEntity<?> getAttendances() {
        return ResponseEntity.ok().body(stampService.getAttendances());
    }

    @GetMapping("/api/stamp")
    public ResponseEntity<?> getUserCheck() {
        return ResponseEntity.ok(stampService.getUserCheck());
    }
}
