package com.dogtiger.challus.controller;

import com.dogtiger.challus.dto.CommentResDto;
import com.dogtiger.challus.dto.CreateCommentReqDto;
import com.dogtiger.challus.dto.FeedReqDto;
import com.dogtiger.challus.entity.Challenge;
import com.dogtiger.challus.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FeedController {
    private final FeedService feedService;

    @PostMapping("/api/challenge/feed/{challengeId}")
    public ResponseEntity<?> feed(@PathVariable int challengeId,
                                  @RequestBody FeedReqDto feedReqDto) {
        feedReqDto.setChallengeId(challengeId);
        System.out.println(feedReqDto);
        return ResponseEntity.ok(feedService.saveFeed(feedReqDto));
    }

    @GetMapping("/api/challenge/certification/feed/{page}")
    public ResponseEntity<?> getFeed(@PathVariable int page){
        return ResponseEntity.ok(feedService.getFeeds(page));
    }

    @GetMapping("/api/feed/{feedId}/like/count")
    public ResponseEntity<Integer> getFeedLikeCount(@PathVariable int feedId){
        return ResponseEntity.ok(feedService.getFeedLikeCount(feedId));
    }

    @GetMapping("/api/feed/{feedId}/like")
    public ResponseEntity<Integer> getMyFeedLike(@PathVariable int feedId){
        return ResponseEntity.ok(feedService.getMyFeedLike(feedId));
    }

    @PostMapping("/api/feed/{feedId}/like")
    public ResponseEntity<?> likeToFeed(@PathVariable int feedId) throws Exception {
        feedService.likeToFeed(feedId);
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/api/feed/{feedId}/like")
    public ResponseEntity<?> cancelLikeToFeed(@PathVariable int feedId) throws Exception {
        feedService.cancelLikeToFeed(feedId);
        return ResponseEntity.ok("");
    }

    @PostMapping("/api/feed/{feedId}/comment")
    public ResponseEntity<?> createComment(@PathVariable int feedId, @RequestBody CreateCommentReqDto createCommentReqDto) {
        feedService.createComment(feedId, createCommentReqDto);
        return ResponseEntity.ok("");
    }

    @GetMapping("/api/feed/{feedId}/comments")
    public ResponseEntity<List<CommentResDto>> getFeedComments(@PathVariable int feedId) {
        return ResponseEntity.ok(feedService.getFeedComments(feedId));
    }

    @GetMapping("/api/feed/{feedId}/comment/latest")
    public ResponseEntity<CommentResDto> getLatestFeedComment(@PathVariable int feedId) {
        return ResponseEntity.ok(feedService.getLatestFeedComment(feedId));
    }
}