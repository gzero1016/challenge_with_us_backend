package com.dogtiger.challus.controller;

import com.dogtiger.challus.dto.ChallengeCreateReqDto;
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

}
