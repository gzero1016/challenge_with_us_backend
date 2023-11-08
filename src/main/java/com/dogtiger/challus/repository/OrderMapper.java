package com.dogtiger.challus.repository;

import com.dogtiger.challus.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    public int saveOrder(Order order);
}
