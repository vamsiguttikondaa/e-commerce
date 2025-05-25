package com.product_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.product_service.dto.ProductDetailResponseDTO;
import com.product_service.dto.ProductRequestDto;
import com.product_service.dto.ProductResponseDTO;
import com.product_service.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService proService;

    // Create product
    @PostMapping("/")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDto dto) {
        return new ResponseEntity<>(proService.createProduct(dto), HttpStatus.CREATED);
    }

    // Get all products (basic response)
    @GetMapping("/")
    public ResponseEntity<List<ProductResponseDTO>> getProducts() {
        return new ResponseEntity<>(proService.getAllProducts(), HttpStatus.OK);
    }

    // Get product by ID (with detail + image list)
    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailResponseDTO> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(proService.getProductById(id), HttpStatus.OK);
    }

    // Delete product by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        proService.deleteProduct(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }
    //update product
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductRequestDto dto) {
        return new ResponseEntity<>(proService.updateProduct(id, dto), HttpStatus.OK);
    }

}
