package com.dogtiger.challus.controller;

import com.dogtiger.challus.dto.PrincipalResDto;
import com.dogtiger.challus.entity.User;
import com.dogtiger.challus.enums.StoreItem;
import com.dogtiger.challus.security.PrincipalUser;
import com.dogtiger.challus.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/api/store/items")
    public ResponseEntity<?> getItems() {
        return ResponseEntity.ok(storeService.getItems());
    }

    @PostMapping("/api/store/item")
    public ResponseEntity<?> purchaseItem(@RequestBody Map<String, Integer> map) {
        int itemId = map.get("itemId");
        storeService.purchaseItem(itemId);
        return ResponseEntity.ok("");
    }

    @GetMapping("/api/store/purchases/{userId}")
    public ResponseEntity<?> getOrderList(@PathVariable int userId) {
        return ResponseEntity.ok(storeService.getOrderList(userId));
    }
}