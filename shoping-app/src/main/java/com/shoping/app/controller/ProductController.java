package com.shoping.app.controller;


import com.shoping.app.exception.ResourceNotFoundException;
import com.shoping.app.model.Product;
import com.shoping.app.response.ApiResponse;
import com.shoping.app.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/allProducts")
    public ResponseEntity<ApiResponse> getAllProduct(){
        List<Product> allProducts = productService.getAllProducts();
        return ResponseEntity.ok(new ApiResponse("sucess",allProducts));

    }
    @GetMapping("/product/{id}")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable Long id){
        try {
            Product productById = productService.getProductById(id);
            return ResponseEntity.ok(new ApiResponse("success",productById));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }
    }

}
