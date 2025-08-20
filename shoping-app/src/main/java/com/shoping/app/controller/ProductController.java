package com.shoping.app.controller;


import com.shoping.app.dto.ProductDto;
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

    @GetMapping("all")
    public ResponseEntity<ApiResponse> getAllProduct(){
        List<Product> allProducts = productService.getAllProducts();
        List<ProductDto> convertedProducts = productService.getConvertedProducts(allProducts);
        return ResponseEntity.ok(new ApiResponse("success",convertedProducts));

    }
    @GetMapping("/product-by-id/{id}")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable Long id){
        try {
            Product productById = productService.getProductById(id);
            ProductDto productDto = productService.convertToDto(productById);
            return ResponseEntity.ok(new ApiResponse("success",productDto));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody AddProductRequest product) {
        try {
            Product theProduct = productService.addProduct(product);
            ProductDto productDto = productService.convertToDto(theProduct);
            return ResponseEntity.ok(new ApiResponse("Add product success!", productDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PutMapping("product/{id}")
    public ResponseEntity<ApiResponse> updateProduct(@RequestBody ProductUpdateRequest product, @PathVariable Long id){

        try {
            Product updatedProduct = productService.updateProduct(product, id);
            ProductDto productDto = productService.convertToDto(updatedProduct);
            return ResponseEntity.ok(new ApiResponse("success",productDto));
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
            List<ProductDto> convertedProducts = productService.getConvertedProducts(productsByBrandAndName);
            return ResponseEntity.ok(new ApiResponse("success",convertedProducts));
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
            List<ProductDto> convertedProducts = productService.getConvertedProducts(productsByCategoryAndBrand);
            return ResponseEntity.ok(new ApiResponse("success",convertedProducts));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }


    @GetMapping("/product-by-name/{productName}")
    public ResponseEntity<ApiResponse> getProductByName(@PathVariable String productName){

        try {
            List<Product> productsByName = productService.getProductsByName(productName);

            if (productsByName.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("no product found with name !",null));
            }
            List<ProductDto> convertedProducts = productService.getConvertedProducts(productsByName);
            return ResponseEntity.ok(new ApiResponse("success",convertedProducts));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("product-by-brand/{name}")
    public ResponseEntity<ApiResponse> getProductByBrand(@PathVariable String name){

        try {
            List<Product> productsByBrand = productService.getProductsByBrand(name);
            if (productsByBrand.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("no product found with brand !",null));
            }
            List<ProductDto> convertedProducts = productService.getConvertedProducts(productsByBrand);
            return ResponseEntity.ok(new ApiResponse("success",convertedProducts));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }
    @GetMapping("product-by-category/{categoryName}")
    public ResponseEntity<ApiResponse> getProductByCategoryName(@PathVariable String categoryName){

        try {
            List<Product> productsByCategory = productService.getProductsByCategoryName(categoryName);
            if (productsByCategory.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("no product found with category !",null));
            }
            List<ProductDto> convertedProducts = productService.getConvertedProducts(productsByCategory);
            return ResponseEntity.ok(new ApiResponse("success",convertedProducts));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/products/count/by-brand-name")
    public ResponseEntity<ApiResponse> CountProductsByBrandAndName(@RequestParam String brandName,@RequestParam String name){

        try {
            var countProductsByBrandAndName = productService.CountProductsByBrandAndName(brandName, name);

            return ResponseEntity.ok(new ApiResponse("product count",countProductsByBrandAndName));
        } catch (Exception e) {
            return ResponseEntity.ok(new ApiResponse(e.getMessage(),null));
        }
    }
}

