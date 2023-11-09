package com.dogtiger.challus.entity;

import com.dogtiger.challus.dto.StoreOrderResDto;
import com.dogtiger.challus.enums.StoreItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int orderId;
    private int userId;
    private int itemId;
    private int itemPrice;

    public StoreOrderResDto toStoreOrderResDto() {
        return StoreOrderResDto.builder()
                .orderId(orderId)
                .itemId(itemId)
                .itemName(StoreItem.getItemNameByItemId(itemId))
                .itemPrice(itemPrice)
                .build();
    }
}
