package com.dogtiger.challus.controller;

import com.dogtiger.challus.dto.ChallengeApplicableReqDto;
import com.dogtiger.challus.dto.LetterReqDto;
import com.dogtiger.challus.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class LetterController {
    private final LetterService letterService;

    @GetMapping("/api/letters")
    public ResponseEntity<?> getLetters() {
        System.out.println(letterService.getLetters());
        return ResponseEntity.ok(letterService.getLetters());
    }

    @GetMapping("/api/letters/count")
    public ResponseEntity<?> getLettersCount() {
        return ResponseEntity.ok(letterService.getLettersCount());
    }

    @PutMapping("/api/letter/{letterId}/is-read")
    public ResponseEntity<Boolean> changeReadStatus(@PathVariable int letterId) {
        return ResponseEntity.ok(letterService.changeReadStatus(letterId));
    }

    @PostMapping("/api/challenge/atmosphere/letter")
    public ResponseEntity<?> challengeAtmosphereLetter(@RequestBody Map<String, LetterReqDto> requestData) {
        LetterReqDto letterReqDto = requestData.get("data");
        System.out.println(letterReqDto);
        return ResponseEntity.ok(letterService.challengeAtmosphereLetter(letterReqDto));
    }
}