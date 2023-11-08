package com.dogtiger.challus.repository;

import com.dogtiger.challus.entity.Feed;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedMapper {
    public int saveFeed(Feed feed);
}
