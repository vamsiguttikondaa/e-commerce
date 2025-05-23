package com.product_service.service;

import java.util.List;

import com.product_service.dto.ProductDetailResponseDTO;
import com.product_service.dto.ProductRequestDto;
import com.product_service.dto.ProductResponseDTO;
import com.product_service.entities.Product;

public interface ProductService {
	ProductResponseDTO createProduct(ProductRequestDto dto);
    ProductDetailResponseDTO getProductById(Long id);
    List<ProductResponseDTO> getAllProducts();
    void deleteProduct(Long id);
    boolean isValid(Long id);
    Product getProductEntityById(Long id);
    void setPrimary(Product product,String url);
}
