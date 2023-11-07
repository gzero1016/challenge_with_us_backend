package com.dogtiger.challus.controller;

import com.dogtiger.challus.dto.ChallengeCreateReqDto;
import com.dogtiger.challus.dto.ChallengeLikeReqDto;
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
}
