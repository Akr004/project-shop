package com.shoping.app.service.product;

import com.shoping.app.model.Product;
import com.shoping.app.request.AddProductRequest;
import com.shoping.app.request.ProductUpdateRequest;

import java.util.List;

public interface ProductService {

    Product addProduct(AddProductRequest product);
    Product getProductById(Long id);
    void deleteProductById(Long id);
    Product updateProduct(ProductUpdateRequest product, Long id);
    List<Product> getAllProducts();
    List<Product> getProductsByCategoryName(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategoryAndBrand(String Category,String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByBrandAndName(String brand,String name);
    Long CountProductsByBrandAndName(String brand,String name);


}
