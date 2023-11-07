package com.dogtiger.challus.repository;

import com.dogtiger.challus.entity.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeMapper {
    public int saveNotice(Notice notice);

    public List<Notice> noticeList(Map<String, Object> paramsMap);
}
