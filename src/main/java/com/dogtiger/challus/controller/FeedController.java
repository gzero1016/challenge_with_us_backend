package com.dogtiger.challus.controller;

import com.dogtiger.challus.dto.*;
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
        return ResponseEntity.ok(feedService.saveFeed(feedReqDto));
    }

    @PutMapping("/api/challenge/feed/{feedId}")
    public ResponseEntity<?> updateFeed(@PathVariable int feedId,
                                  @RequestBody UpdateFeedReqDto updateFeedReqDto) {
        return ResponseEntity.ok(feedService.updateFeed(feedId, updateFeedReqDto));
    }

    @GetMapping("/api/challenge/feed/{feedId}")
    public ResponseEntity<?> getFeed(@PathVariable int feedId) {
        return ResponseEntity.ok(feedService.getFeed(feedId));
    }

    @DeleteMapping("/api/challenge/feed/{feedId}")
    public ResponseEntity<?> deleteFeed(@PathVariable int feedId) {
        return ResponseEntity.ok(feedService.deleteFeed(feedId));
    }

    @GetMapping("/api/challenge/certification/feed/{page}/{challengeId}")
    public ResponseEntity<?> getFeedDetailList(@PathVariable int page,
                                     @PathVariable int challengeId){
        return ResponseEntity.ok(feedService.getFeedDetails(page, challengeId));
    }

    @GetMapping("/api/challenge/certification/feed/{page}")
    public ResponseEntity<?> getFeedList(@PathVariable int page,
                                     @RequestParam String sort){
        return ResponseEntity.ok(feedService.getFeeds(page, sort));
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

    @PutMapping("/api/feed/{feedId}/comment/{commentId}")
    public ResponseEntity<?> modifyComment(@PathVariable int feedId, @PathVariable int commentId, @RequestBody ModifyCommentReqDto modifyCommentReqDto) throws Exception {
        System.out.println(modifyCommentReqDto);
        feedService.modifyComment(feedId, commentId, modifyCommentReqDto);
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/api/feed/{feedId}/comment/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable int feedId, @PathVariable int commentId) throws Exception {
        feedService.deleteComment(feedId, commentId);
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

    @GetMapping("/api/admin/feed/count")
    public ResponseEntity<?> getFeedCount() {
        return ResponseEntity.ok(feedService.getMembersCount());
    }
}