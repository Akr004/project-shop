package com.order_service.order_service.external;


import com.order_service.order_service.response.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "SHOPPING-API",url = "http://localhost:8083")
public interface CartItemClient {

    @PostMapping("/item/add")
    public ResponseEntity<ApiResponse> addItemToCart(@RequestParam(required = false) Long cartId,
                                                     @RequestParam Long productId,
                                                     @RequestParam Integer quantity);

    @DeleteMapping("/item/{cartId}/{productId}")
    public ResponseEntity<ApiResponse> removeItemFromCart(@PathVariable Long cartId, @PathVariable Long productId);

    @PutMapping("/item/update")
    public ResponseEntity<ApiResponse> updateItemQuantity(
            @RequestParam Long cartId,
            @RequestParam Long productId,
            @RequestParam Integer quantity);

}
