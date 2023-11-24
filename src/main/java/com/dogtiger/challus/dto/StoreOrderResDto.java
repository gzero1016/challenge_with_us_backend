package com.dogtiger.challus.dto;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StoreOrderResDto {
    private int orderId;
    private int itemId;
    private String itemName;
    private int itemPrice;
    private String orderTime;
}