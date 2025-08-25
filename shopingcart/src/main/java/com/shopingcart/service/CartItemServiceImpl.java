package com.shopingcart.service;

import com.shopingcart.exception.ResourceNotFoundException;
import com.shopingcart.external.ProductService;
import com.shopingcart.model.Cart;
import com.shopingcart.model.CartItem;
import com.shopingcart.payload.ProductDto;
import com.shopingcart.repository.CartItemRepository;
import com.shopingcart.repository.CartRepository;
import com.shopingcart.response.ApiResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Transactional
public class CartItemServiceImpl implements CartItemService{

    private final CartItemRepository cartItemRepository;
    private final ProductService productService;
    private final CartService cartService;
    private final CartRepository cartRepository;
    @Override
    public void addItemToCart(Long cartId, Long productId, int quantity) {
    // 1. get the cart
    // 2. get the product
    // 3. check if product already in the cart
    // 4. if yes, then increase the quantity
    // 5. if no, initiate a new cart item
        Cart cart = cartRepository.findById(cartId).orElseThrow(()->new ResourceNotFoundException("not found"));
        ProductDto productDto = productService.getProductById(productId);
        CartItem cartItem1 = cart.getCartItems()
                .stream()
                .filter(cartItem -> cartItem.getProductId().equals(productId))
                .findFirst().orElse(new CartItem());

        if(cartItem1.getId()==null){
            cartItem1.setCart(cart);
            cartItem1.setProductId(productId);
            cartItem1.setQuantity(quantity);
            cartItem1.setTotalPrice(productDto.getPrice());
        }

        else {
            cartItem1.setQuantity(cartItem1.getQuantity()+quantity);
        }
        cartItem1.setTotalPrice();
        cart.addItem(cartItem1);
        cartItemRepository.save(cartItem1);
        cartRepository.save(cart);

    }

    @Override
    public void removeItemFromCart(Long cartId, Long productId) {

        Cart cart = cartRepository.findById(cartId).orElseThrow(()->new ResourceNotFoundException("not found"));
        CartItem itemToRemove = cart.getCartItems().stream()
                .filter(item -> item.getProductId().equals(productId))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("product not found"));
        cart.removeItem(itemToRemove);
        cartRepository.save(cart);



    }

    @Override
    public void updateItemQuantity(Long cartId, Long productId, int quantity) {

        Cart cart = cartRepository.findById(cartId).orElseThrow(()->new ResourceNotFoundException("not found"));
        cart.getCartItems().stream()
                .filter(item->item.getProductId().equals(productId))
                .findFirst()
                .ifPresent(item -> {
                    item.setQuantity(quantity);
                    item.setUnitPrice(productService.getProductById(productId).getPrice());
                    item.setTotalPrice();
                } );
        BigDecimal totalAmount = cart.getTotalAmount();
        cart.setTotalAmount(totalAmount);
        cartRepository.save(cart);


    }
    @Override
    public CartItem getCartItem(Long cartId, Long productId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(()->new ResourceNotFoundException("not found"));
        return  cart.getCartItems()
                .stream()
                .filter(item -> item.getProductId().equals(productId))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("Item not found"));
    }
}
