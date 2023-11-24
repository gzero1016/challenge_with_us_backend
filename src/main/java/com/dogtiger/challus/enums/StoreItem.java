package com.dogtiger.challus.enums;

import java.util.Arrays;

public enum StoreItem {

    STORE_ONLINE_GIFTCARD_5_THOUSAND(1, "온라인문화상품권(5,000원)", 2000, "https://firebasestorage.googleapis.com/v0/b/challengewithus-1ffef.appspot.com/o/files%2Fstore%2Fimg_culture_221019.jpg?alt=media&token=9c089dc8-87cb-4525-b0e7-674f36722e3b"),
    STORE_ONLINE_GIFTCARD_10_THOUSAND(2, "온라인문화상품권(10,000원)", 4000, "https://firebasestorage.googleapis.com/v0/b/challengewithus-1ffef.appspot.com/o/files%2Fstore%2Fimg_culture_221019.jpg?alt=media&token=9c089dc8-87cb-4525-b0e7-674f36722e3b"),
    STORE_SMART_GIFTCARD_5_THOUSAND(3, "스마트문화상품권(5,000원)", 2000, "https://firebasestorage.googleapis.com/v0/b/challengewithus-1ffef.appspot.com/o/files%2Fstore%2Fimg_game_culture_221019.jpg?alt=media&token=6eefd73f-0254-45ca-932e-f64005c3b7aa"),
    STORE_SMART_GIFTCARD_10_THOUSAND(4, "스마트문화상품권(10,000원)", 4000, "https://firebasestorage.googleapis.com/v0/b/challengewithus-1ffef.appspot.com/o/files%2Fstore%2Fimg_game_culture_221019.jpg?alt=media&token=6eefd73f-0254-45ca-932e-f64005c3b7aa"),
    STORE_HAPPY_GIFTCARD_5_THOUSAND(5, "해피머니문화상품권(5,000원)", 2000, "https://firebasestorage.googleapis.com/v0/b/challengewithus-1ffef.appspot.com/o/files%2Fstore%2Fimg_happy_221019.jpg?alt=media&token=93e0fa2a-9732-4a8f-ba02-149e61272eb6"),
    STORE_HAPPY_GIFTCARD_10_THOUSAND(6, "해피머니문화상품권(10,000원)", 4000, "https://firebasestorage.googleapis.com/v0/b/challengewithus-1ffef.appspot.com/o/files%2Fstore%2Fimg_happy_221019.jpg?alt=media&token=93e0fa2a-9732-4a8f-ba02-149e61272eb6"),
    STORE_NEXON_GIFTCARD_5_THOUSAND(7, "넥슨카드(5,000원)", 2000, "https://firebasestorage.googleapis.com/v0/b/challengewithus-1ffef.appspot.com/o/files%2Fstore%2Fimg_nexoncard_221019.jpg?alt=media&token=63187b86-b6e6-412f-a01e-f86d9691255c"),
    STORE_NEXON_GIFTCARD_10_THOUSAND(8, "넥슨카드(10,000원)", 4000, "https://firebasestorage.googleapis.com/v0/b/challengewithus-1ffef.appspot.com/o/files%2Fstore%2Fimg_nexoncard_221019.jpg?alt=media&token=63187b86-b6e6-412f-a01e-f86d9691255c"),
    STORE_GOOGLE_GIFTCARD_1_THOUSAND(9, "구글기프트카드(1,000원)", 400, "https://firebasestorage.googleapis.com/v0/b/challengewithus-1ffef.appspot.com/o/files%2Fstore%2Fimg_googlegift_221019.jpg?alt=media&token=55832c46-ef7c-412a-932c-4992ac7f6b31"),
    STORE_GOOGLE_GIFTCARD_3_THOUSAND(10, "구글기프트카드(3,000원)", 1200, "https://firebasestorage.googleapis.com/v0/b/challengewithus-1ffef.appspot.com/o/files%2Fstore%2Fimg_googlegift_221019.jpg?alt=media&token=55832c46-ef7c-412a-932c-4992ac7f6b31"),
    STORE_GOOGLE_GIFTCARD_5_THOUSAND(11, "구글기프트카드(5,000원)", 2000, "https://firebasestorage.googleapis.com/v0/b/challengewithus-1ffef.appspot.com/o/files%2Fstore%2Fimg_googlegift_221019.jpg?alt=media&token=55832c46-ef7c-412a-932c-4992ac7f6b31"),
    STORE_GOOGLE_GIFTCARD_10_THOUSAND(12, "구글기프트카드(10,000원)", 4000, "https://firebasestorage.googleapis.com/v0/b/challengewithus-1ffef.appspot.com/o/files%2Fstore%2Fimg_googlegift_221019.jpg?alt=media&token=55832c46-ef7c-412a-932c-4992ac7f6b31"),
    STORE_AFRICA_STARBALLOON_1_THOUSAND(13, "별풍선교환권[아프리카TV](1,000원)", 400, "https://firebasestorage.googleapis.com/v0/b/challengewithus-1ffef.appspot.com/o/files%2Fstore%2Fimg_starballoon_221019.jpg?alt=media&token=efee8e2f-37bd-4b1c-bfb8-0dc29b98e935"),
    STORE_AFRICA_STARBALLOON_3_THOUSAND(14, "별풍선교환권[아프리카TV](3,000원)", 1200, "https://firebasestorage.googleapis.com/v0/b/challengewithus-1ffef.appspot.com/o/files%2Fstore%2Fimg_starballoon_221019.jpg?alt=media&token=efee8e2f-37bd-4b1c-bfb8-0dc29b98e935"),
    STORE_AFRICA_STARBALLOON_5_THOUSAND(15, "별풍선교환권[아프리카TV](5,000원)", 2000, "https://firebasestorage.googleapis.com/v0/b/challengewithus-1ffef.appspot.com/o/files%2Fstore%2Fimg_starballoon_221019.jpg?alt=media&token=efee8e2f-37bd-4b1c-bfb8-0dc29b98e935"),
    STORE_AFRICA_STARBALLOON_10_THOUSAND(16, "별풍선교환권[아프리카TV](10,000원)", 4000, "https://firebasestorage.googleapis.com/v0/b/challengewithus-1ffef.appspot.com/o/files%2Fstore%2Fimg_starballoon_221019.jpg?alt=media&token=efee8e2f-37bd-4b1c-bfb8-0dc29b98e935");


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