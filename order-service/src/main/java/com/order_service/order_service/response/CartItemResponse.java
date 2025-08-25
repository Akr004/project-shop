package com.order_service.order_service.response;

import com.shopingcart.payload.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CartItemResponse {
    private Long id;
    private Long productId;
    private int quantity;
    private BigDecimal totalPrice;
    private ProductDto productDto;
}