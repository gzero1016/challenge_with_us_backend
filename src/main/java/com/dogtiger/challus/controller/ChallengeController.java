package com.dogtiger.challus.controller;

import com.dogtiger.challus.dto.*;
import com.dogtiger.challus.exception.InvalidDateRangeException;
import com.dogtiger.challus.security.PrincipalUser;
import com.dogtiger.challus.service.ChallengeService;
import com.dogtiger.challus.service.FeedService;
import com.dogtiger.challus.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ChallengeController {
    private final ChallengeService challengeService;
    private final FeedService feedService;
    private final LetterService letterService;

    @PostMapping("/api/challenge/create")
    public ResponseEntity<?> savechallenge(@RequestBody ChallengeCreateReqDto challengeCreateReqDto) throws Exception {

        return ResponseEntity.ok().body(challengeService.saveChallenge(challengeCreateReqDto));

    }

    @GetMapping("/api/challenge/{challengeId}")
    public ResponseEntity<GetChallengeRespDto> getChallenge(@PathVariable int challengeId) {
        return ResponseEntity.ok(challengeService.getChallenge(challengeId));
    }

    @GetMapping("/api/challenges/{page}")
    public ResponseEntity<List<ChallengeListRespDto>> getChallengeList(
            @PathVariable int page,
            SearchChallengeListReqDto searchChallengeListReqDto) {

        return ResponseEntity.ok(challengeService.getChallengeList(page, searchChallengeListReqDto));
    }

    @GetMapping("/api/challenges/popular")
    public ResponseEntity<GetChallengeRespDto> getPopularChallenge(@RequestParam String year, @RequestParam String month, @RequestParam String date) {
        GetPopularChallengeReqDto getPopularChallengeReqDto = GetPopularChallengeReqDto.builder().year(year == "" ? null : year).month(month == "" ? null : month).date(date == "" ? null : date).build();
        return ResponseEntity.ok(challengeService.getPopularChallenge(getPopularChallengeReqDto));
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

    @GetMapping("/api/challenge/{challengeId}/progress")
    public ResponseEntity<?> getChallengeProgress(@PathVariable int challengeId) {
        return ResponseEntity.ok(challengeService.getChallengeProgress(challengeId));
    }

    @PostMapping("/api/challenge/feed/{challengeUserId}/point")
    public ResponseEntity<?> saveFeedPoint(@PathVariable int challengeUserId) {
        System.out.println(challengeUserId);
        return ResponseEntity.ok(challengeService.saveFeedPoint(challengeUserId));
    }

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

    @PostMapping("/api/challenge/atmosphere/letter")
    public ResponseEntity<?> challengeAtmosphereLetter(@RequestBody LetterReqDto letterReqDto) {
        return ResponseEntity.ok(letterService.challengeAtmosphereLetter(letterReqDto));
    }

    @PostMapping("/api/challenge/report")
    public ResponseEntity<?> challengeReport(@RequestBody ReportReqDto reportReqDto) {
        return ResponseEntity.ok(letterService.challengeReport(reportReqDto));
    }
}