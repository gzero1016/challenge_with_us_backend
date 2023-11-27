package com.dogtiger.challus.controller;

import com.dogtiger.challus.service.AuthService;
import com.dogtiger.challus.service.ChallengeService;
import com.dogtiger.challus.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminController {
    private final AuthService authService;
    private final ChallengeService challengeService;
    private final FeedService feedService;

    @GetMapping("/api/admin/members/count")
    public ResponseEntity<?> getUserCount() {
        return ResponseEntity.ok(authService.getMembersCount());
    }

    @GetMapping("/api/admin")
    public ResponseEntity<?> adminListUser() {
        return ResponseEntity.ok(authService.adminListGet());
    }

    @GetMapping("/api/admin/challengers/count")
    public ResponseEntity<?> getChallengesCount() {
        return ResponseEntity.ok(challengeService.getChallengesCount());
    }

    @GetMapping("/api/admin/challenges/completed/count")
    public ResponseEntity<?> getChallengeCompletedCount() {
        return ResponseEntity.ok(challengeService.getChallengeCompletedCount());
    }

    @GetMapping("/api/admin/challenges/deleted/count")
    public ResponseEntity<?> getChallengeDeletedCount() {
        return ResponseEntity.ok(challengeService.getChallengeDeletedCount());
    }

    @GetMapping("/api/admin/feed/count")
    public ResponseEntity<?> getFeedCount() {
        return ResponseEntity.ok(feedService.getMembersCount());
    }
}
