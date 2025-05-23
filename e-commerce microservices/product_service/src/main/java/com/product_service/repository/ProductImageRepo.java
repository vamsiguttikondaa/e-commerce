package com.product_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product_service.entities.ProductImage;

@Repository
public interface ProductImageRepo extends JpaRepository<ProductImage, Long> {
		
}
