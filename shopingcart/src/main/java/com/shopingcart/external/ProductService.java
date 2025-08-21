package com.shopingcart.external;

import com.shopingcart.payload.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "SHOPPING-API")
public interface ProductService {

    @GetMapping("/product-by-id/{id}")
    Product getProductById(@PathVariable Long id);

    @PostMapping("/add")
    Product addProduct(@PathVariable Long id);

    @PutMapping("product/{id}")
 Product updateProduct(@RequestBody Product product, @PathVariable Long id);

    }
