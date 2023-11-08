package com.dogtiger.challus.service;

import com.dogtiger.challus.dto.PointReqDto;
import com.dogtiger.challus.repository.PointMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointService {
    private final PointMapper pointMapper;

    public boolean savepoint(PointReqDto pointReqDto) {
        return pointMapper.savePoint(pointReqDto.toPointEntity()) > 0;
    }

    public boolean usePoint(PointReqDto pointReqDto) {
        return pointMapper.usePoint(pointReqDto.toPointEntity()) > 0;
    }
}