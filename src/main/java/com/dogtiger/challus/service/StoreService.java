package com.dogtiger.challus.service;


import com.dogtiger.challus.dto.ItemsResDto;
import com.dogtiger.challus.enums.StoreItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    public List<ItemsResDto> getItems() {
        List<ItemsResDto> items = new ArrayList<>();
        Arrays.stream(StoreItem.values()).forEach((item) -> {
            items.add(
                ItemsResDto.builder()
                        .itemId(item.getItemId())
                        .itemName(item.getItemName())
                        .itemPrice(item.getItemPrice())
                        .itemImgUrl(item.getItemImgUrl())
                        .build()
            );
        });
        return items;
    }
}