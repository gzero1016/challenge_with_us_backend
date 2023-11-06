package com.dogtiger.challus.controller;


import com.dogtiger.challus.dto.NoticewriteReqDto;
import com.dogtiger.challus.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    @PostMapping("/api/notice")
    public ResponseEntity<?> noticewrite(@RequestBody NoticewriteReqDto noticewriteReqDto){

        return ResponseEntity.ok(noticeService.saveNotice(noticewriteReqDto));
    }
}