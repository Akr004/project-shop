package com.order_service.order_service.response;

import com.shopingcart.response.CartItemResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class CartResponse {
    private Long id;
    private List<CartItemResponse> cartItems;
    private BigDecimal totalAmount;
}