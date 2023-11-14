package com.dogtiger.challus.entity;

import com.dogtiger.challus.dto.FeedResDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedLike {
    private int feedLikeId;
    private int feedId;
    private int userId;
}
