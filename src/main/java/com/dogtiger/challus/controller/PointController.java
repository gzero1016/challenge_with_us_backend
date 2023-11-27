package com.dogtiger.challus.controller;
import com.dogtiger.challus.dto.PointReqDto;
import com.dogtiger.challus.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PointController {
    private final PointService pointService;

    @PostMapping("/api/point")
    public ResponseEntity<?> savepoint(@RequestBody PointReqDto pointReqDto) {
        return ResponseEntity.ok(pointService.savepoint(pointReqDto));
    }
}
