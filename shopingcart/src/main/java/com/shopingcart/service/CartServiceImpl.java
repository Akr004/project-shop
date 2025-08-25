package com.shopingcart.service;

import com.shopingcart.exception.ResourceNotFoundException;
import com.shopingcart.external.ProductService;
import com.shopingcart.model.Cart;
import com.shopingcart.model.CartItem;
import com.shopingcart.payload.ProductDto;
import com.shopingcart.repository.CartItemRepository;
import com.shopingcart.repository.CartRepository;
import com.shopingcart.response.CartItemResponse;
import com.shopingcart.response.CartResponse;
import jakarta.persistence.Version;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
@Transactional
public class CartServiceImpl implements CartService{

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductService productService;
    @Version
    private final AtomicLong cartIdGenerator= new AtomicLong(0);
//    @Override
//    public Cart getCart(Long id) {
//        Cart cart = cartRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cart Not Found"));
//        BigDecimal totalAmount=cart.getTotalAmount();
//        cart.setTotalAmount(totalAmount);
//        return cartRepository.save(cart);
//    }

    @Override
    @Transactional
    public CartResponse getCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        // Map cart items + fetch product info
        List<CartItemResponse> items = cart.getCartItems().stream()
                .map(item -> {
                    ProductDto productDto = productService.getProductById(item.getProductId());
                    return new CartItemResponse(
                            item.getId(),
                            item.getProductId(),
                            item.getQuantity(),
                            item.getTotalPrice(),

                            productDto   // enrich with product details
                    );
                })
                .toList();

        return new CartResponse(cart.getId(), items, cart.getTotalAmount());
    }


    @Override
    public void clearCart(Long id) {

        Cart cart=cartRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("not found"));
        cartItemRepository.deleteAllByCartId(id);
        cart.getCartItems().clear();
        cartRepository.deleteById(id);


    }
//
//    @Override
//    public BigDecimal getTotalPrice(Long id) {
//
//        Cart cart=cartRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("not found"));
//        return cart.getTotalAmount();
//
//        return cart.getCartItems().stream().map(CartItem::getTotalPrice)
//                .reduce(BigDecimal.ZERO,BigDecimal::add);
//    }

    @Override
    public BigDecimal getTotalPrice(Long id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        return cart.getCartItems().stream()
                .map(CartItem::getTotalPrice) // must handle null inside CartItem
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    @Override
    public Long initializeNewCart(){
        Cart newCart= new Cart();
        Long newCartId = cartIdGenerator.incrementAndGet();
        newCart.setId(newCartId);
        return cartRepository.save(newCart).getId();
    }
}
