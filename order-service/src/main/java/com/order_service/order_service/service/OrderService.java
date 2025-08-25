package com.order_service.order_service.service;

import com.order_service.order_service.model.Order;

public interface OrderService {

    Order placeOrder(Long userId);
    Order getOrder(Long orderId);
}
