package com.shoping.app.controller;

import com.shoping.app.exception.AlreadyExistsException;
import com.shoping.app.exception.ResourceNotFoundException;
import com.shoping.app.model.Category;
import com.shoping.app.response.ApiResponse;
import com.shoping.app.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("categories")
    public ResponseEntity<ApiResponse> getAllCategories(){

        try {
            List<Category> categories = categoryService.getAllCategories();
            return ResponseEntity.ok(new ApiResponse("Found !",categories));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Error",HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @PostMapping("/addCategory")
    public ResponseEntity<ApiResponse> addCategory(@RequestBody Category category){
        try {
            Category addedCategory = categoryService.addCategory(category);
            return ResponseEntity.ok(new ApiResponse("Success!",addedCategory));
        } catch (AlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(e.getMessage(),null));
        }
    }
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<ApiResponse> getCategoryById(@PathVariable Long categoryId){
        try {
            Category categoryById = categoryService.getCategoryById(categoryId);
            return ResponseEntity.ok(new ApiResponse("Found !",categoryById));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),HttpStatus.NOT_FOUND));
        }
    }
    @GetMapping("/category/{categoryName}")
    public ResponseEntity<ApiResponse> getCategoryByName(@PathVariable String categoryName){
        try {
            Category categoryByName = categoryService.getCategoryByName(categoryName);
            return ResponseEntity.ok(new ApiResponse("Found !",categoryByName));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),HttpStatus.NOT_FOUND));
        }
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<ApiResponse> getCategoryByName(@PathVariable Long id){
        try {
            categoryService.deleteCategoryById(id);
            return ResponseEntity.ok(new ApiResponse("Deleted !",null));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),HttpStatus.NOT_FOUND));
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable Long id,@RequestBody Category category){
        try {
            Category updateCategory = categoryService.updateCategory(category,id);
            return ResponseEntity.ok(new ApiResponse("Success!",updateCategory));
        } catch (AlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }
    }

}
