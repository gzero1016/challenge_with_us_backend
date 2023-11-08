package com.dogtiger.challus.controller;

import com.dogtiger.challus.dto.ChallengeCreateReqDto;
import com.dogtiger.challus.dto.SearchChallengeListReqDto;
import com.dogtiger.challus.service.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

}
