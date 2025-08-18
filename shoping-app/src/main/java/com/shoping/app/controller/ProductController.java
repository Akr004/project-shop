package com.shoping.app.controller;


import com.shoping.app.exception.ResourceNotFoundException;
import com.shoping.app.model.Product;
import com.shoping.app.request.AddProductRequest;
import com.shoping.app.request.ProductUpdateRequest;
import com.shoping.app.response.ApiResponse;
import com.shoping.app.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/product")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody AddProductRequest product) {

        try {
            Product addProduct = productService.addProduct(product);
            return ResponseEntity.ok(new ApiResponse("product added successfully!", addProduct));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ApiResponse> updateProduct(@RequestBody ProductUpdateRequest product, @PathVariable Long id){

        try {
            Product updatedProduct = productService.updateProduct(product, id);
            return ResponseEntity.ok(new ApiResponse("success",updatedProduct));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteProduct( @PathVariable Long id){

        try {
            productService.deleteProductById(id);
            return ResponseEntity.ok(new ApiResponse("success",id));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/products/by/brand-and-name")
    public ResponseEntity<ApiResponse> getProductByBrandAndName(@RequestParam String brandName,@RequestParam String productName){

        try {
            List<Product> productsByBrandAndName = productService.getProductsByBrandAndName(brandName, productName);
            if (productsByBrandAndName.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("no product found with name !",null));
            }
            return ResponseEntity.ok(new ApiResponse("success",productsByBrandAndName));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/products/by/category-and-brand")
    public ResponseEntity<ApiResponse> getProductByCategoryAndBrand(@RequestParam String categoryName,@RequestParam String brandName){

        try {
            List<Product> productsByCategoryAndBrand = productService.getProductsByCategoryAndBrand(categoryName, brandName);
            if (productsByCategoryAndBrand.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("no category found with brand !",null));
            }
            return ResponseEntity.ok(new ApiResponse("success",productsByCategoryAndBrand));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }


    @GetMapping("/product/{productName}")
    public ResponseEntity<ApiResponse> getProductByName(@PathVariable String productName){

        try {
            List<Product> productsByName = productService.getProductsByName(productName);
            if (productsByName.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("no product found with name !",null));
            }
            return ResponseEntity.ok(new ApiResponse("success",productsByName));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/product/{brandName}")
    public ResponseEntity<ApiResponse> getProductByBrand(@PathVariable String brandName){

        try {
            List<Product> productsByBrand = productService.getProductsByBrand(brandName);
            if (productsByBrand.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("no product found with brand !",null));
            }
            return ResponseEntity.ok(new ApiResponse("success",productsByBrand));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }
    @GetMapping("/product/{categoryName}")
    public ResponseEntity<ApiResponse> getProductByCategoryName(@PathVariable String categoryName){

        try {
            List<Product> productsByCategory = productService.getProductsByCategoryName(categoryName);
            if (productsByCategory.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("no product found with category !",null));
            }
            return ResponseEntity.ok(new ApiResponse("success",productsByCategory));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/products/by/brand-and-name")
    public ResponseEntity<ApiResponse> CountProductsByBrandAndName(@RequestParam String brandName,@RequestParam String name){

        try {
            var countProductsByBrandAndName = productService.CountProductsByBrandAndName(brandName, name);

            return ResponseEntity.ok(new ApiResponse("product count",countProductsByBrandAndName));
        } catch (Exception e) {
            return ResponseEntity.ok(new ApiResponse(e.getMessage(),null));
        }
    }
}

