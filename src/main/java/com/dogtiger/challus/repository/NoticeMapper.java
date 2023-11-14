package com.dogtiger.challus.repository;

import com.dogtiger.challus.entity.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeMapper {
    public int saveNotice(Notice notice);
    public List<Notice> getNoticeList(Map<String, Object> paramsMap);
    public Notice getNoticeByNoticeId(int noticeId);
    public Integer getNoticesCount();
    public int deleteNotice(int noticeId);
    public int updateNotice(Notice notice);

}
