package com.webstoreapp.mybatis;

import com.webstoreapp.entity.Order;
import javax.inject.Inject;
import org.mybatis.cdi.Mapper;

public class OrderService {

    @Inject
    @Mapper
    private OrderMapper orderMapper;

    public Order createOrder(Integer offerId, Integer userId, String status) {
        orderMapper.insertOrder(offerId, userId, status);
        return orderMapper.selectOrder(offerId, userId, status);
    }

    public Order getOrderById(Integer id) {
        return orderMapper.selectOrderById(id);
    }

    public void deleteOrder(Integer id) {
        orderMapper.deleteOrder(id);
    }

}
