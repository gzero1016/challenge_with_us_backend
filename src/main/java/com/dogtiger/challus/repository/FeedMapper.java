package com.dogtiger.challus.repository;

import com.dogtiger.challus.entity.Comment;
import com.dogtiger.challus.entity.Feed;
import com.dogtiger.challus.entity.FeedLike;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FeedMapper {
    public int saveFeed(Feed feed);
    public int updateFeed(Feed feed);
    public List<Feed> getFeeds(Map<String, Object> paramsMap);
    public List<Feed> getFeedDetails(int index, int challengeId);
    Integer getFeedLikeCountByFeedId(int feedId);
    int findFeedLikeCountByFeedIdAndUserId(int feedId, int userId);
    int insertFeedLike(FeedLike feedLike);
    int deleteFeedLike(FeedLike feedLike);
    int insertComment(Comment build);
    int updateComment(Comment comment);
    Comment findCommentByCommentId(int commentId);
    int deleteCommentByCommentId(int commentId);
    List<Comment> findCommentsByFeedId(int feedId);
    Comment getLatestCommentByFeedId(int feedId);
    List<Map<String, Object>> getFeedsCount();
}
