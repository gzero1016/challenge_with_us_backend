package com.dogtiger.challus.service;

import com.dogtiger.challus.dto.NoticewriteReqDto;
import com.dogtiger.challus.entity.Notice;
import com.dogtiger.challus.entity.User;
import com.dogtiger.challus.repository.NoticeMapper;
import com.dogtiger.challus.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeMapper noticeMapper;
    private final UserMapper userMapper;


    public boolean saveNotice(NoticewriteReqDto noticewriteReqDto) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userMapper.findUserByEmail(email);
        Notice notice = noticewriteReqDto.toNoticeEntity(user.getUserId());
        return noticeMapper.saveNotice(notice) > 0;
    }
}
