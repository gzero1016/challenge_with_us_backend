package com.dogtiger.challus.enums;

import java.util.Arrays;

public enum StoreItem {

    STORE_GIFTICON_5_THOUSAND(1, "편의점 기프티콘(5,000원)", 2000, ""),
    STORE_GIFTICON_10_THOUSAND(2, "편의점 기프티콘(10,000원)", 4000, "");

    private final int itemId;
    private final String itemName;
    private final int itemPrice;
    private final String itemImgUrl;


    StoreItem(int itemId, String itemName, int itemPrice, String itemImgUrl) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemImgUrl = itemImgUrl;
    }
    public int getItemId() {
        return this.itemId;
    }
    public String getItemName() {
        return this.itemName;
    }
    public int getItemPrice() {
        return this.itemPrice;
    }
    public String getItemImgUrl() {
        return this.itemImgUrl;
    }
}