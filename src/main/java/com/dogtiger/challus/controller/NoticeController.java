package com.dogtiger.challus.controller;


import com.dogtiger.challus.dto.NoticeEditReqDto;
import com.dogtiger.challus.dto.NoticeListRespDto;
import com.dogtiger.challus.dto.NoticeWriteReqDto;
import com.dogtiger.challus.dto.SearchNoticeListReqDto;
import com.dogtiger.challus.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<?> noticeListGet(@PathVariable int page, SearchNoticeListReqDto searchNoticeListReqDto){
        System.out.println(page);
        List<NoticeListRespDto> noticeList = noticeService.noticeListGet(page, searchNoticeListReqDto);
        return ResponseEntity.ok(noticeList);
    }

    @GetMapping("/api/notices/count")
    public ResponseEntity<Integer> getNoticesCount(SearchNoticeListReqDto searchNoticeListReqDto){
        return ResponseEntity.ok(noticeService.getNoticesCount(searchNoticeListReqDto));
    }

    @GetMapping("/api/notice/{noticeId}")
    public ResponseEntity<?> getNotice(@PathVariable int noticeId){
        return ResponseEntity.ok(noticeService.getNotice(noticeId));
    }

    @DeleteMapping("/api/notice/{noticeId}")
    public ResponseEntity<?> deleteNotice(@PathVariable int noticeId){
        System.out.println(noticeId);
        return ResponseEntity.ok(noticeService.deleteNotice(noticeId));
    }

    @PutMapping("/api/notice/{noticeId}")
    public ResponseEntity<?> editBoard(@PathVariable int noticeId,
                                       @Valid @RequestBody NoticeEditReqDto noticeEditReqDto,
                                       BindingResult bindingResult) {

        return ResponseEntity.ok(noticeService.editNotice(noticeId, noticeEditReqDto));
    }
}