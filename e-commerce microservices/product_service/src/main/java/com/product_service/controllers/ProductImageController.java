package com.product_service.controllers;

import com.product_service.dto.ProductImageDTO;
import com.product_service.dto.ProductImageResponseDTO;
import com.product_service.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-image")
public class ProductImageController {

    @Autowired
    private ProductImageService imageService;

    @PostMapping("/{productId}")
    public ResponseEntity<ProductImageResponseDTO> createImage(
            @PathVariable Long productId,
            @RequestBody ProductImageDTO imageDTO) {
        return ResponseEntity.ok(imageService.createImage(imageDTO, productId));
    }

    @GetMapping("/{imageId}")
    public ResponseEntity<ProductImageResponseDTO> getImage(@PathVariable Long imageId) {
        return ResponseEntity.ok(imageService.getImage(imageId));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductImageResponseDTO>> getProductImages(@PathVariable Long productId) {
        return ResponseEntity.ok(imageService.getProductImages(productId));
    }

    @DeleteMapping("/{imageId}")
    public ResponseEntity<String> deleteImage(@PathVariable Long imageId) {
        imageService.deleteImage(imageId);
        return ResponseEntity.ok("Image deleted successfully.");
    }

    @PutMapping("/{imageId}")
    public ResponseEntity<ProductImageResponseDTO> updateImage(
            @PathVariable Long imageId,
            @RequestBody ProductImageDTO dto) {
        return ResponseEntity.ok(imageService.updateImage(imageId, dto));
    }
}
