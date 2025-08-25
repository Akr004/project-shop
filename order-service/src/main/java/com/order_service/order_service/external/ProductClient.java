package com.order_service.order_service.external;


import com.order_service.order_service.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "SHOPPING-API",url = "http://localhost:8081")
public interface ProductClient {

    @GetMapping("/api/v1/products/{id}")
    ProductDto getProductById(@PathVariable("id") Long id);

    @PostMapping
    ProductDto addProduct(@RequestBody ProductDto productDto);

    @PutMapping("/api/v1/{id}")
    Prduct updateProduct(@RequestBody ProductDto productDto, @PathVariable("id") Long id);
}


