package com.dogtiger.challus.controller;

import com.dogtiger.challus.dto.*;
import com.dogtiger.challus.exception.InvalidDateRangeException;
import com.dogtiger.challus.security.PrincipalUser;
import com.dogtiger.challus.service.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ChallengeController {
    private final ChallengeService challengeService;

    @PostMapping("/api/challenge/create")
    public ResponseEntity<?> savechallenge(@RequestBody ChallengeCreateReqDto challengeCreateReqDto) throws InvalidDateRangeException {

        return ResponseEntity.ok().body(challengeService.saveChallenge(challengeCreateReqDto));
    }

    @GetMapping("/api/challenge/{challengeId}")
    public ResponseEntity<?> getChallenge(@PathVariable int challengeId) {
        return ResponseEntity.ok(challengeService.getChallenge(challengeId));
    }

    @GetMapping("/api/challenges/{page}")
    public ResponseEntity<?> getChallengeList(
            @PathVariable int page,
            SearchChallengeListReqDto searchChallengeListReqDto) {

        System.out.println(searchChallengeListReqDto);
        return ResponseEntity.ok(challengeService.getChallengeList(page, searchChallengeListReqDto));
    }

    @GetMapping("/api/challenges/count")
    public ResponseEntity<?> getChallengeCount(
            SearchChallengeListReqDto searchChallengeListReqDto) {
        return ResponseEntity.ok(challengeService.getChallengeCount(searchChallengeListReqDto));
    }

    @GetMapping("/api/challenge/{challengeId}/like")
    public ResponseEntity<?> getLikeState(@PathVariable int challengeId) {
        return ResponseEntity.ok(challengeService.getLikeState(challengeId));
    }

    @GetMapping("/api/challenge/{challengeId}/userlike")
    public ResponseEntity<?> getUserLikeState(@PathVariable int challengeId,
                                              @RequestParam int userId) {
        ChallengeLikeReqDto challengeLikeReqDto = new ChallengeLikeReqDto();
        challengeLikeReqDto.setUserId(userId);
        challengeLikeReqDto.setChallengeId(challengeId);
        return ResponseEntity.ok(challengeService.getUserLikeState(challengeLikeReqDto));
    }

    @PostMapping("/api/challenge/{challengeId}/like")
    public ResponseEntity<?> insertLike(@PathVariable int challengeId, @RequestBody ChallengeLikeReqDto challengeLikeReqDto) {
        challengeLikeReqDto.setChallengeId(challengeId);
        return ResponseEntity.ok(challengeService.insertLike(challengeLikeReqDto));
    }

    @DeleteMapping("/api/challenge/{challengeId}/like")
    public ResponseEntity<?> cancelLike(@PathVariable int challengeId, @RequestBody ChallengeLikeReqDto challengeLikeReqDto) {
        challengeLikeReqDto.setChallengeId(challengeId);
        return ResponseEntity.ok(challengeService.cancelLike(challengeLikeReqDto));
    }

    @DeleteMapping("/api/challenge/{challengeId}")
    public ResponseEntity<?> challengeDelete(@PathVariable int challengeId) {
        return ResponseEntity.ok(challengeService.challengeDelete(challengeId));
    }

    @GetMapping("/api/challenge/join/{challengeId}")
    public ResponseEntity<?> getChallengeStatus(@PathVariable int challengeId) {
        return ResponseEntity.ok(challengeService.getChallengeStatus(challengeId));
    }

    @GetMapping("/api/challenge/atmospher/{challengeId}")
    public ResponseEntity<?> getChallengeAtmospher(@PathVariable int challengeId) {
        return ResponseEntity.ok(challengeService.getChallengeAtmospher(challengeId));
    }

    @PostMapping("/api/challenge/join/{challengeId}")
    public ResponseEntity<?> challengeApplicable(@PathVariable int challengeId) {
        return ResponseEntity.ok(challengeService.challengeApplicable(challengeId));
    }
    @GetMapping("/api/challengers/{challengeId}")
    public ResponseEntity<?> getChallengers(@PathVariable int challengeId) {
        return ResponseEntity.ok(challengeService.getChallengers(challengeId));
    }

    @DeleteMapping("/api/challenger/{challengeId}")
    public ResponseEntity<?> deleteChallenger(@PathVariable int challengeId, int userId) {
        return ResponseEntity.ok(challengeService.deleteChallenger(challengeId, userId));
    }
    @PutMapping("/api/challenge/approval")
    public ResponseEntity<?> challengeApproval(@RequestBody Map<String, ChallengeApplicableReqDto> requestData) {
        ChallengeApplicableReqDto challengeApplicableReqDto = requestData.get("data");

        return ResponseEntity.ok(challengeService.challengeApproval(challengeApplicableReqDto));
    }

    @PutMapping("/api/challenge/refusal")
    public ResponseEntity<?> challengeRefusal(@RequestBody Map<String, ChallengeApplicableReqDto> requestData) {
        ChallengeApplicableReqDto challengeApplicableReqDto = requestData.get("data");

        return ResponseEntity.ok(challengeService.challengeRefusal(challengeApplicableReqDto));
    }

    @PutMapping("/api/challenge/stop/{challengeId}")
    public ResponseEntity<?> challengeStop(@PathVariable int challengeId) {
        return ResponseEntity.ok(challengeService.challengeStop(challengeId));
    }

    @PutMapping("/api/challenge/hidden/{challengeId}")
    public ResponseEntity<?> challengeHidden(@PathVariable int challengeId) {
        return ResponseEntity.ok(challengeService.challengeHidden(challengeId));
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

    @GetMapping("/api/challenge/{challengeId}/progress")
    public ResponseEntity<?> getChallengeProgress(@PathVariable int challengeId) {
        return ResponseEntity.ok(challengeService.getChallengeProgress(challengeId));
    }

    @PostMapping("/api/challenge/feed/{challengeUserId}/point")
    public ResponseEntity<?> saveFeedPoint(@PathVariable int challengeUserId) {
        System.out.println(challengeUserId);
        return ResponseEntity.ok(challengeService.saveFeedPoint(challengeUserId));
    }
}