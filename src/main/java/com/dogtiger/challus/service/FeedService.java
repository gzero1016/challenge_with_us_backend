package com.dogtiger.challus.service;


import com.dogtiger.challus.dto.*;
import com.dogtiger.challus.entity.Comment;
import com.dogtiger.challus.entity.Feed;
import com.dogtiger.challus.entity.FeedLike;
import com.dogtiger.challus.repository.FeedMapper;
import com.dogtiger.challus.security.PrincipalUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    public List<CommentResDto> getFeedComments(int feedId) {
        return feedMapper.findCommentsByFeedId(feedId).stream().map(comment -> comment.toCommentResDto()).collect(Collectors.toList());
    }

    public Integer getFeedLikeCount(int feedId) {
        return feedMapper.getFeedLikeCountByFeedId(feedId);
    }

    public Integer getMyFeedLike(int feedId) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getUser().getUserId();
        return feedMapper.findFeedLikeCountByFeedIdAndUserId(feedId, userId);
    }

    public void likeToFeed(int feedId) throws Exception {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getUser().getUserId();
        if(feedMapper.findFeedLikeCountByFeedIdAndUserId(feedId, userId) > 0) {
            throw new Exception("이미 좋아요 상태 입니다");
        }

        int result = feedMapper.insertFeedLike(FeedLike.builder()
                .feedId(feedId)
                .userId(userId)
                .build());

        if(result == 0) {
            throw new Exception("좋아요 실패");
        }
    }

    public void cancelLikeToFeed(int feedId) throws Exception {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getUser().getUserId();
        if(feedMapper.findFeedLikeCountByFeedIdAndUserId(feedId, userId) == 0) {
            throw new Exception("이미 좋아요 취소 상태 입니다");
        }

        int result = feedMapper.deleteFeedLike(FeedLike.builder()
                .feedId(feedId)
                .userId(userId)
                .build());

        if(result == 0) {
            throw new Exception("좋아요 취소 실패");
        }
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

    public void deleteComment(int feedId, int commentId) throws Exception {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getUser().getUserId();
        Comment targetComment = feedMapper.findCommentByCommentId(commentId);

        if(targetComment == null) {
            throw new Exception("대상 댓글 존재하지 않음");
        }

        if(targetComment.getFeedId() != feedId) {
            throw new Exception("올바르지 않은 요청");
        }

        if(targetComment.getUserId() != userId) {
            throw new Exception("다른 사람의 댓글은 지울 수 없음");
        }

        feedMapper.deleteCommentByCommentId(commentId);
    }

    public CommentResDto getLatestFeedComment(int feedId) {
        Comment comment = feedMapper.getLatestCommentByFeedId(feedId);

        if(comment == null) {
            return null;
        }

        return comment.toCommentResDto();
    }
}