package com.dogtiger.challus.repository;

import com.dogtiger.challus.dto.CommentResDto;
import com.dogtiger.challus.entity.Comment;
import com.dogtiger.challus.entity.Feed;
import com.dogtiger.challus.entity.FeedLike;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface FeedMapper {
    public int saveFeed(Feed feed);
    public int getLikeCountByFeedId(int feedId);
    public List<Feed> getFeeds(int index);
    Integer getFeedLikeCountByFeedId(int feedId);
    int findFeedLikeCountByFeedIdAndUserId(int feedId, int userId);
    int insertFeedLike(FeedLike feedLike);
    int deleteFeedLike(FeedLike feedLike);
    int insertComment(Comment build);
    Comment findCommentByCommentId(int commentId);
    int deleteCommentByCommentId(int commentId);
    List<Comment> findCommentsByFeedId(int feedId);
    Comment getLatestCommentByFeedId(int feedId);
}
