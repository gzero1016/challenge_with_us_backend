package com.dogtiger.challus.controller;

import com.dogtiger.challus.dto.ChallengeCreateReqDto;
import com.dogtiger.challus.dto.PointReqDto;
import com.dogtiger.challus.service.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ChallengeController {
    private final ChallengeService challengeService;

    @PostMapping("/api/challenge/create/{userId}")
    public ResponseEntity<?> savechallenge(@PathVariable int userId,
                                           @RequestBody ChallengeCreateReqDto challengeCreateReqDto){
        challengeCreateReqDto.setUserId(userId);
        System.out.println(challengeCreateReqDto);
        return ResponseEntity.ok().body(challengeService.saveChallenge(challengeCreateReqDto));
    }

}
