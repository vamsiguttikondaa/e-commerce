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
		System.out.println(image);
		System.out.println(productId);
	    // 1. Check if product is valid
	    Product product = proService.getProductEntityById(productId); // throws exception if invalid
	    System.out.println(product.getId());
	    // 2. Convert DTO to Entity
	    ProductImage imageEntity = dtoConverter.convertToProductImage(image);
	    System.out.println("after being converted to dto "+imageEntity);

	    // 3. Set the product object
	    imageEntity.setProduct(product);
	    System.out.println("after setting thr product "+imageEntity);

	    // 4. Save image
	    ProductImage saved = proImgRepo.save(imageEntity);
	    System.out.println("saved image"+saved);

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductImageResponseDTO> getProductImages(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

}
