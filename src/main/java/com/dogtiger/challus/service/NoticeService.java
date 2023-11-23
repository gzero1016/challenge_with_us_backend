package com.dogtiger.challus.service;

import com.dogtiger.challus.dto.*;
import com.dogtiger.challus.entity.Letter;
import com.dogtiger.challus.entity.Notice;
import com.dogtiger.challus.entity.User;
import com.dogtiger.challus.repository.LetterMapper;
import com.dogtiger.challus.repository.NoticeMapper;
import com.dogtiger.challus.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeMapper noticeMapper;
    private final UserMapper userMapper;
    private final LetterMapper letterMapper;

    @Transactional(rollbackFor = Exception.class)
    public boolean saveNotice(NoticeWriteReqDto noticewriteReqDto) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userMapper.findUserByEmail(email);
        Notice notice = noticewriteReqDto.toNoticeEntity(user.getUserId());
        boolean result = noticeMapper.saveNotice(notice) > 0;

        List<Integer> userIds = userMapper.getUserIdAll();

        userIds.stream().forEach(
                (receiverUserId) -> {
                    if(user.getUserId() != receiverUserId) {
                        letterMapper.insertLetter(Letter.builder()
                                .senderUserId(user.getUserId())
                                .receiverUserId(receiverUserId)
                                .title("새로운 공지가 있습니다.")
                                .content(notice.getNoticeContent())
                                .targetUrl("http://localhost:3000/notice/" + notice.getNoticeId())
                                .targetId(notice.getNoticeId())
                                .build());
                    }
                }
        );

        return result;
    }

    public List<NoticeListRespDto> noticeListGet(int page) {
        int index = (page - 1) * 10;
        List<NoticeListRespDto> noticeListRespDtos = new ArrayList<>();
        noticeMapper.getNoticeList(page, index).forEach(notice -> {
            noticeListRespDtos.add(notice.noticeListRespDto());
        });

        return noticeListRespDtos;
    }

    public Integer getNoticesCount() {
        return noticeMapper.getNoticesCount();
    }

    public NoticeGetRespDto getNotice(int noticeId) {

        NoticeGetRespDto noticeGetRespDto = noticeMapper.getNoticeByNoticeId(noticeId).toNoticeDto();
        return noticeGetRespDto;
    }

    public boolean deleteNotice(int noticeId){
        return noticeMapper.deleteNotice(noticeId) > 0 ;
    }

    public boolean editNotice(int noticeId, NoticeEditReqDto noticeEditReqDto) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userMapper.findUserByEmail(email);
        Notice notice = noticeEditReqDto.toNoticeEntity(user.getUserId());
        notice.setNoticeId(noticeId);
        return noticeMapper.updateNotice(notice) > 0;
    }
}