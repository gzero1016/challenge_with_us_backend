package com.dogtiger.challus.controller;

import com.dogtiger.challus.dto.PrincipalResDto;
import com.dogtiger.challus.entity.User;
import com.dogtiger.challus.security.PrincipalUser;
import com.dogtiger.challus.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/api/store/items")
    public ResponseEntity<?> getItems() {
        return ResponseEntity.ok(storeService.getItems());
    }
}