package com.dogtiger.challus.controller;

import com.dogtiger.challus.dto.ChallengeCreateReqDto;
import com.dogtiger.challus.dto.SearchChallengeListReqDto;
import com.dogtiger.challus.dto.ChallengeLikeReqDto;
import com.dogtiger.challus.dto.FeedReqDto;
import com.dogtiger.challus.security.PrincipalUser;
import com.dogtiger.challus.service.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ChallengeController {
    private final ChallengeService challengeService;

    @PostMapping("/api/challenge/create")
    public ResponseEntity<?> savechallenge(@RequestBody ChallengeCreateReqDto challengeCreateReqDto){
        System.out.println(challengeCreateReqDto);
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
        System.out.println(challengeLikeReqDto);
        return ResponseEntity.ok(challengeService.insertLike(challengeLikeReqDto));
    }

    @DeleteMapping("/api/challenge/{challengeId}/like")
    public ResponseEntity<?> cancelLike(@PathVariable int challengeId, @RequestBody ChallengeLikeReqDto challengeLikeReqDto) {
        challengeLikeReqDto.setChallengeId(challengeId);
        System.out.println(challengeLikeReqDto);
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
        System.out.println(challengeId + ", " + userId);
        return ResponseEntity.ok(challengeService.deleteChallenger(challengeId, userId));
    }
}
