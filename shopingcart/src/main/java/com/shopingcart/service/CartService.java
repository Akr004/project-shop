package com.shopingcart.service;

import com.shopingcart.model.Cart;
import com.shopingcart.response.CartResponse;

import java.math.BigDecimal;

public interface CartService {

    CartResponse getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);

    Long initializeNewCart();
}
