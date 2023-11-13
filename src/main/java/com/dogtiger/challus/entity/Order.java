package com.dogtiger.challus.entity;

import com.dogtiger.challus.dto.StoreOrderResDto;
import com.dogtiger.challus.enums.StoreItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int orderId;
    private int userId;
    private int itemId;
    private int itemPrice;
    private LocalDateTime orderTime;

    public StoreOrderResDto toStoreOrderResDto() {
        return StoreOrderResDto.builder()
                .orderId(orderId)
                .itemId(itemId)
                .itemName(StoreItem.getItemNameByItemId(itemId))
                .itemPrice(itemPrice)
                .orderTime(orderTime.format(DateTimeFormatter.ofPattern("MM월dd일 HH시mm분")))
                .build();
    }
}
