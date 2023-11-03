package com.dogtiger.challus.repository;

import com.dogtiger.challus.entity.Point;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PointMapper {
    public int savePoint(Point point);
}
