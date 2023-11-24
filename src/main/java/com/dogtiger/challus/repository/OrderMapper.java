package com.dogtiger.challus.repository;

import com.dogtiger.challus.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface OrderMapper {
    public int saveOrder(Order order);

    List<Order> findOrdersByUserId(int userId);
}
