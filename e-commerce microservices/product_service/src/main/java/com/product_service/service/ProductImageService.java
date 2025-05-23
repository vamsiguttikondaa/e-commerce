package com.product_service.service;

import java.util.List;

import com.product_service.dto.ProductImageDTO;
import com.product_service.dto.ProductImageResponseDTO;

public interface ProductImageService {
	ProductImageResponseDTO createImage(ProductImageDTO image,Long productId);
	ProductImageResponseDTO getImage(Long id);
	List<ProductImageResponseDTO> getProductImages(Long productId);
					
}
