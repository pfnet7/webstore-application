package com.webstoreapp.mybatis;

import com.webstoreapp.entity.Order;

public interface OrderMapper {

    void insertOrder(Integer offerId, Integer userId, String status);

    Order selectOrderById(Integer id);

    Order selectOrder(Integer offerId, Integer userId, String status);

    void deleteOrder(Integer id);

}
