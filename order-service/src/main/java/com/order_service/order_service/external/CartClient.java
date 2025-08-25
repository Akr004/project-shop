package com.order_service.order_service.external;


import com.order_service.order_service.payload.Cart;
import com.order_service.order_service.response.ApiResponse;
import com.order_service.order_service.response.CartResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CART-API",url = "http://localhost:8083")
public interface CartClient {

    @GetMapping("/cart/{cartId}")
    Cart getCart(@PathVariable Long cartId);

    @DeleteMapping("/cart/{cartId}")
   void clearCart(@PathVariable Long id);


    @GetMapping("/cart/amount/{cartId}")
    public ResponseEntity<ApiResponse> getTotalAmount(@PathVariable Long cartId);
}
