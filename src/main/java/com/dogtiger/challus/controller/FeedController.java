package com.dogtiger.challus.controller;

import com.dogtiger.challus.dto.FeedReqDto;
import com.dogtiger.challus.entity.Challenge;
import com.dogtiger.challus.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
