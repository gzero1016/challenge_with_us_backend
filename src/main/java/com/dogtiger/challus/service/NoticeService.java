package com.dogtiger.challus.service;

import com.dogtiger.challus.dto.NoticeGetRespDto;
import com.dogtiger.challus.dto.NoticeListRespDto;
import com.dogtiger.challus.dto.NoticeWriteReqDto;
import com.dogtiger.challus.entity.Notice;
import com.dogtiger.challus.entity.User;
import com.dogtiger.challus.repository.NoticeMapper;
import com.dogtiger.challus.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeMapper noticeMapper;
    private final UserMapper userMapper;

    public boolean saveNotice(NoticeWriteReqDto noticewriteReqDto) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userMapper.findUserByEmail(email);
        Notice notice = noticewriteReqDto.toNoticeEntity(user.getUserId());
        return noticeMapper.saveNotice(notice) > 0;
    }

    public List<NoticeListRespDto> noticeListGet(int page) {
        Map<String, Object> paramsMap = new HashMap<>();
        int index = (page - 1) * 10;
        paramsMap.put("index", index);
        List<NoticeListRespDto> noticeListRespDtos = new ArrayList<>();
        noticeMapper.getNoticeList(paramsMap).forEach(notice -> {
            noticeListRespDtos.add(notice.noticeListRespDto());
        });

        return noticeListRespDtos;
    }

    public Integer getNoticesCount() {
        return noticeMapper.getNoticesCount();
    }

    public NoticeGetRespDto getNotice(int noticeId) {

        NoticeGetRespDto noticeGetRespDto = noticeMapper.getNoticeByNoticeId(noticeId).toNoticeDto();
        System.out.println(noticeGetRespDto);
        return noticeGetRespDto;
    }
}