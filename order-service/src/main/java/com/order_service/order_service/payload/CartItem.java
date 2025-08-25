package com.order_service.order_service.payload;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItem {

    private Long id;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;
    private Long productId;
    private Cart cart;
}
