package com.order_service.order_service.payload;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class Cart {

    private Long id;
    private BigDecimal totalAmount=BigDecimal.ZERO;
    private Set<CartItem> cartItems;
}
