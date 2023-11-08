package com.dogtiger.challus.entity;

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
}
