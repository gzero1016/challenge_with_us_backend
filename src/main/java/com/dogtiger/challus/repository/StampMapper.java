package com.dogtiger.challus.repository;

import com.dogtiger.challus.entity.Comment;
import com.dogtiger.challus.entity.Feed;
import com.dogtiger.challus.entity.FeedLike;
import com.dogtiger.challus.entity.Stamp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StampMapper {
    public int saveAttendance(Stamp stamp);
    public List<Stamp> getAttendances(int userId);
    public int getUserCheck(int userId);
}
