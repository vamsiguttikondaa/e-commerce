package com.product_service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product_service.dto.ProductImageDTO;
import com.product_service.dto.ProductImageResponseDTO;
import com.product_service.entities.Product;
import com.product_service.entities.ProductImage;
import com.product_service.repository.ProductImageRepo;
import com.product_service.repository.ProductRepo;
import com.product_service.service.ProductImageService;
import com.product_service.service.ProductService;
import com.product_service.utility.DtoConverter;

import jakarta.transaction.Transactional;

@Service
public class ProductImageServiceImpl implements ProductImageService {

	@Autowired
	private ProductImageRepo proImgRepo;
	@Autowired
	private ProductService proService;
	@Autowired
	private DtoConverter dtoConverter;

	@Override
	
	public ProductImageResponseDTO createImage(ProductImageDTO image, Long productId) {
		
	    // 1. Check if product is valid
	    Product product = proService.getProductEntityById(productId); // throws exception if invalid
	    
	    // 2. Convert DTO to Entity
	    ProductImage imageEntity = dtoConverter.convertToProductImage(image);
	 

	    // 3. Set the product object
	    imageEntity.setProduct(product);
	  

	    // 4. Save image
	    ProductImage saved = proImgRepo.save(imageEntity);
	  

	    // 5. If this is primary, update product table
	    if (saved.isPrimary()) {
	        proService.setPrimary(product,saved.getImageUrl());
	    }

	    // 6. Build and return DTO
	    return ProductImageResponseDTO.builder()
	    		.id(saved.getId())
	            .imageUrl(saved.getImageUrl())
	            .isPrimary(saved.isPrimary())
	            .productId(productId)
	            .build();
	}

	@Override
	public ProductImageResponseDTO getImage(Long id) {
		ProductImage image = proImgRepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Image not found with ID: " + id));

	    return ProductImageResponseDTO.builder()
	            .id(image.getId())
	            .imageUrl(image.getImageUrl())
	            .isPrimary(image.isPrimary())
	            .productId(image.getProduct().getId())
	            .build();
	}

	@Override
	public List<ProductImageResponseDTO> getProductImages(Long productId) {
		 Product product = proService.getProductEntityById(productId);

		    List<ProductImage> images = proImgRepo.findByProduct(product);

		    return images.stream()
		            .map(img -> ProductImageResponseDTO.builder()
		                    .id(img.getId())
		                    .imageUrl(img.getImageUrl())
		                    .isPrimary(img.isPrimary())
		                    .productId(productId)
		                    .build())
		            .toList();
	}
	@Override
	public void deleteImage(Long imageId) {
	    ProductImage image = proImgRepo.findById(imageId)
	            .orElseThrow(() -> new RuntimeException("Image not found with ID: " + imageId));

	    proImgRepo.delete(image);
	}
	@Override
	public ProductImageResponseDTO updateImage(Long imageId, ProductImageDTO dto) {
	    ProductImage existing = proImgRepo.findById(imageId)
	            .orElseThrow(() -> new RuntimeException("Image not found with ID: " + imageId));

	    existing.setImageUrl(dto.getImageUrl());
	    existing.setPrimary(dto.getIsPrimary());

	    ProductImage updated = proImgRepo.save(existing);

	    // Also update product primaryImageUrl if needed
	    if (updated.isPrimary()) {
	        proService.setPrimary(updated.getProduct(), updated.getImageUrl());
	    }

	    return ProductImageResponseDTO.builder()
	            .id(updated.getId())
	            .imageUrl(updated.getImageUrl())
	            .isPrimary(updated.isPrimary())
	            .productId(updated.getProduct().getId())
	            .build();
	}

}
