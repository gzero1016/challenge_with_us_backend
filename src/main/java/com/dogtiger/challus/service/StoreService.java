package com.dogtiger.challus.service;


import com.dogtiger.challus.dto.ItemsResDto;
import com.dogtiger.challus.dto.StoreOrderResDto;
import com.dogtiger.challus.entity.Letter;
import com.dogtiger.challus.entity.Order;
import com.dogtiger.challus.entity.Point;
import com.dogtiger.challus.entity.User;
import com.dogtiger.challus.enums.StoreItem;
import com.dogtiger.challus.repository.LetterMapper;
import com.dogtiger.challus.repository.OrderMapper;
import com.dogtiger.challus.repository.PointMapper;
import com.dogtiger.challus.security.PrincipalUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final OrderMapper orderMapper;
    private final PointMapper pointMapper;
    private final LetterMapper letterMapper;

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

    @Transactional(rollbackFor = Exception.class)
    public void purchaseItem(Integer itemId) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = principalUser.getUser();
        Integer itemPrice = StoreItem.getItemPriceByItemId(itemId);

        if(user.getPoint() < itemPrice) {
            throw new IllegalArgumentException("포인트가 부족합니다.");
        }

        orderMapper.saveOrder(Order.builder()
                .userId(user.getUserId())
                .itemId(itemId)
                .itemPrice(itemPrice)
                .build());

        pointMapper.usePoint(Point.builder()
                .userId(user.getUserId())
                .point(itemPrice)
                .build());

        letterMapper.insertLetter(Letter.builder()
                .senderUserId(1)
                .receiverUserId(user.getUserId())
                .letterTitle("상점구매")
                .title("구매하신 상품 정보를 보내드립니다.")
                .content("상품명 : " + StoreItem.getItemNameByItemId(itemId))
                .targetUrl("https://firebasestorage.googleapis.com/v0/b/challengewithus-1ffef.appspot.com/o/files%2F%E1%84%8F%E1%85%B2%E1%84%8B%E1%85%A1%E1%86%AF.jpeg?alt=media&token=1ac08a81-3154-4004-a1e3-a9337d7e97da")
                .targetId(itemId)
                .build());
    }

    public List<StoreOrderResDto> getOrderList(int userId) {
        List<StoreOrderResDto> orderList = null;

        orderList = orderMapper.findOrdersByUserId(userId)
                .stream()
                .map(Order::toStoreOrderResDto)
                .collect(Collectors.toList());
        return orderList;
    }
}