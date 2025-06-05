package com.category_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.category_service.dto.CategoryRequestDTO;
import com.category_service.dto.CategoryResponseDTO;
import com.category_service.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Create Category
    @PostMapping("/")
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO dto) {
        CategoryResponseDTO created = categoryService.createCategory(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Get Category by ID
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable Long id) {
        CategoryResponseDTO category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    // Get All Categories
    @GetMapping("/")
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories() {
        List<CategoryResponseDTO> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    // Update Category
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable Long id, @RequestBody CategoryRequestDTO dto) {
        CategoryResponseDTO updated = categoryService.updateCategory(id, dto);
        return ResponseEntity.ok(updated);
    }

    // Delete Category
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    // Optional: Validate Category ID
    @GetMapping("/{id}/exists")
    public ResponseEntity<Boolean> isCategoryValid(@PathVariable Long id) {
        boolean isValid = categoryService.isValidCategory(id);
        return ResponseEntity.ok(isValid);
    }
}
