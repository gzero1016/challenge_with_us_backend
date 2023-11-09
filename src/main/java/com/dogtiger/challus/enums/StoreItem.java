package com.dogtiger.challus.enums;

import java.util.Arrays;

public enum StoreItem {

    STORE_GIFTICON_5_THOUSAND(1, "편의점 기프티콘(5,000원)", 2000, "https://firebasestorage.googleapis.com/v0/b/challus-8d7a9.appspot.com/o/seven_eleven_5_thousand.jpg?alt=media&token=b2556b06-6cae-4b89-86c1-6713ddbfea8f&_gl=1*123244f*_ga*MTQ2NTk2Mjc1MC4xNjk3NzcxMjQ2*_ga_CW55HF8NVT*MTY5OTMzNTk3MS42LjEuMTY5OTMzNjQxMC40NS4wLjA."),
    STORE_GIFTICON_10_THOUSAND(2, "편의점 기프티콘(10,000원)", 4000, "https://firebasestorage.googleapis.com/v0/b/challus-8d7a9.appspot.com/o/seven_eleven_10_thousand.jpg?alt=media&token=a4ccd4fd-6fc9-4fa3-91b5-5eb9aa203ae0&_gl=1*ojypsp*_ga*MTQ2NTk2Mjc1MC4xNjk3NzcxMjQ2*_ga_CW55HF8NVT*MTY5OTMzNTk3MS42LjEuMTY5OTMzNjQ5OC4zNy4wLjA.");

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

    public static Integer getItemPriceByItemId(int itemId) {
        for (StoreItem item : StoreItem.values()) {
            if (item.getItemId() == itemId) {
                return item.getItemPrice();
            }
        }
        return null;
    }

    public static String getItemNameByItemId(int itemId) {
        for (StoreItem item : StoreItem.values()) {
            if (item.getItemId() == itemId) {
                return item.getItemName();
            }
        }
        return null;
    }
}