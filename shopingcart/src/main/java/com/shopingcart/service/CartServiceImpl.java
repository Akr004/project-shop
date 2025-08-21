package com.shopingcart.service;

import com.shopingcart.exception.ResourceNotFoundException;
import com.shopingcart.model.Cart;
import com.shopingcart.model.CartItem;
import com.shopingcart.repository.CartItemRepository;
import com.shopingcart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    @Override
    public Cart getCart(Long id) {
        Cart cart = cartRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cart Not Found"));
        BigDecimal totalAmount=cart.getTotalAmount();
        cart.setTotalAmount(totalAmount);
        return cartRepository.save(cart);
    }

    @Override
    public void clearCart(Long id) {

        Cart cart=getCart(id);
        cartItemRepository.deleteAllByCartId(id);
        cart.getCartItems().clear();
        cartRepository.deleteById(id);


    }

    @Override
    public BigDecimal getTotalPrice(Long id) {

        Cart cart = getCart(id);
        return cart.getTotalAmount();

//        return cart.getCartItems().stream().map(CartItem::getTotalPrice)
//                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }
}
