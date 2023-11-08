package com.dogtiger.challus.controller;


import com.dogtiger.challus.dto.NoticeListRespDto;
import com.dogtiger.challus.dto.NoticeWriteReqDto;
import com.dogtiger.challus.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    @PostMapping("/api/notice")
    public ResponseEntity<?> noticeWrite(@RequestBody NoticeWriteReqDto noticewriteReqDto){
        return ResponseEntity.ok(noticeService.saveNotice(noticewriteReqDto));
    }

    @GetMapping("/api/notices/{page}")
    public ResponseEntity<?> noticeListGet(@PathVariable int page){
        System.out.println(page);
        List<NoticeListRespDto> noticeList = noticeService.noticeListGet(page);
        return ResponseEntity.ok(noticeList);
    }
}