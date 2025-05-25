package com.product_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product_service.entities.Product;
import com.product_service.entities.ProductImage;

@Repository
public interface ProductImageRepo extends JpaRepository<ProductImage, Long> {
	List<ProductImage> findByProduct(Product product);

}
