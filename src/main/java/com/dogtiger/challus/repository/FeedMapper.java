package com.dogtiger.challus.repository;

import com.dogtiger.challus.dto.CommentResDto;
import com.dogtiger.challus.entity.Comment;
import com.dogtiger.challus.entity.Feed;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface FeedMapper {
    public int saveFeed(Feed feed);
    public List<Feed> getFeeds(int index);
    int insertComment(Comment build);
    List<Comment> findCommentsByFeedId(int feedId);
}
