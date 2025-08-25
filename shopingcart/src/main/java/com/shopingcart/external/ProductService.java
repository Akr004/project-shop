package com.shopingcart.external;

import com.shopingcart.payload.ProductDto;
import com.shopingcart.response.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "SHOPPING-API",url = "http://localhost:8081")
public interface ProductService {

    @GetMapping("/api/v1/products/{id}")
    ProductDto getProductById(@PathVariable("id") Long id);

//    @PostMapping
//    ProductDto addProduct(@RequestBody ProductDto productDto);
//
//    @PutMapping("/{id}")
//    ProductDto updateProduct(@RequestBody ProductDto productDto, @PathVariable("id") Long id);
}


