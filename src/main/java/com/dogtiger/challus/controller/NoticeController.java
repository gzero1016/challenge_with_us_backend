package com.dogtiger.challus.controller;


import com.dogtiger.challus.dto.NoticeListRespDto;
import com.dogtiger.challus.dto.NoticeWriteReqDto;
import com.dogtiger.challus.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    @PostMapping("/api/notice")
    public ResponseEntity<?> noticeWrite(@RequestBody NoticeWriteReqDto noticewriteReqDto){
        return ResponseEntity.ok(noticeService.saveNotice(noticewriteReqDto));
    }
    @GetMapping("/api/notices")
    public ResponseEntity<?> noticeListGet(){
        List<NoticeListRespDto> noticeList = noticeService.noticeListGet();
        return ResponseEntity.ok(noticeList);
    }
}