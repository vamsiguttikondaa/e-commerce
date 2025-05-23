package com.product_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product_service.dto.ProductImageDTO;
import com.product_service.dto.ProductImageResponseDTO;
import com.product_service.service.ProductImageService;

@RestController
@RequestMapping("/api/product-image")
public class ProductImageController {

    @Autowired
    private ProductImageService imageService;

    @PostMapping("/{productId}")
    public ResponseEntity<ProductImageResponseDTO> createImage(
            @PathVariable Long productId,
            @RequestBody ProductImageDTO imageDTO) {
    	System.out.println("from controller dto is "+imageDTO);
        ProductImageResponseDTO response = imageService.createImage(imageDTO, productId);
        return ResponseEntity.ok(response);
    }
}
