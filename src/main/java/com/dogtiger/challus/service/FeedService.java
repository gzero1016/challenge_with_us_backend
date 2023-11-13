package com.dogtiger.challus.service;


import com.dogtiger.challus.dto.ChallengeListRespDto;
import com.dogtiger.challus.dto.CreateCommentReqDto;
import com.dogtiger.challus.dto.FeedReqDto;
import com.dogtiger.challus.dto.FeedResDto;
import com.dogtiger.challus.entity.Comment;
import com.dogtiger.challus.entity.Feed;
import com.dogtiger.challus.repository.FeedMapper;
import com.dogtiger.challus.security.PrincipalUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper feedMapper;

    public boolean saveFeed(FeedReqDto feedReqDto) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getUser().getUserId();
        feedReqDto.setUserId(userId);
        return feedMapper.saveFeed(feedReqDto.toFeedEntity()) > 0;
    }

    public List<FeedResDto> getFeeds(int page) {
        int index = (page - 1) * 5;
        List<FeedResDto> feedList = new ArrayList<>();

        feedMapper.getFeeds(index).forEach(feeds -> {
            feedList.add(feeds.toFeedResDto());
        });
        System.out.println(feedList);
        return feedList;
    }

    public void createComment(int feedId, CreateCommentReqDto createCommentReqDto) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getUser().getUserId();
        feedMapper.insertComment(Comment.builder()
                .feedId(feedId)
                .userId(userId)
                .commentContent(createCommentReqDto.getCommentContent())
                .build());
    }
}
