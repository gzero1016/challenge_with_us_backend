package com.dogtiger.challus.repository;

import com.dogtiger.challus.entity.Notice;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeMapper {
    public int saveNotice(Notice notice);
}
