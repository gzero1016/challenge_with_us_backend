package com.dogtiger.challus.service;

import com.dogtiger.challus.dto.*;
import com.dogtiger.challus.entity.Letter;
import com.dogtiger.challus.entity.Notice;
import com.dogtiger.challus.entity.User;
import com.dogtiger.challus.repository.LetterMapper;
import com.dogtiger.challus.repository.NoticeMapper;
import com.dogtiger.challus.repository.UserMapper;
import com.dogtiger.challus.security.PrincipalUser;
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

    private int getUserId() {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getUser().getUserId();

        return userId;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean saveNotice(NoticeWriteReqDto noticewriteReqDto) {
        int userId = getUserId();
        Notice notice = noticewriteReqDto.toNoticeEntity(userId);
        boolean result = noticeMapper.saveNotice(notice) > 0;

        List<Integer> userIds = userMapper.getUserIdAll();

        userIds.stream().forEach(
                (receiverUserId) -> {
                    if(userId != receiverUserId) {
                        letterMapper.insertLetter(Letter.builder()
                                .senderUserId(userId)
                                .receiverUserId(receiverUserId)
                                .letterTitle("공지")
                                .title(notice.getNoticeTitle())
                                .content(notice.getNoticeContent())
                                .targetUrl("http://localhost:3000/notice/" + notice.getNoticeId())
                                .targetId(notice.getNoticeId())
                                .build());
                    }
                }
        );

        return result;
    }

    public List<NoticeListRespDto> noticeListGet(int page, int pageSize) {
        if(pageSize < 0) {
            throw new IllegalArgumentException("올바르지 않은 페이지 크기 입니다.");
        }
        int index = (page - 1) * pageSize;
        List<NoticeListRespDto> noticeListRespDtos = new ArrayList<>();
        noticeMapper.getNoticeList(page, index, pageSize).forEach(notice -> {
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

        int userId = getUserId();
        Notice notice = noticeEditReqDto.toNoticeEntity(userId);
        notice.setNoticeId(noticeId);
        return noticeMapper.updateNotice(notice) > 0;
    }
}