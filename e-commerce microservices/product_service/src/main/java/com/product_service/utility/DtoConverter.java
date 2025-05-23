package com.product_service.utility;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.product_service.dto.ProductImageDTO;
import com.product_service.dto.ProductResponseDTO;
import com.product_service.dto.ProductRequestDto;
import com.product_service.entities.Product;
import com.product_service.entities.ProductImage;

@Component
public class DtoConverter {

    private final ModelMapper modelMapper;

    public DtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // Product → ProductRequestDTO
    public ProductRequestDto convertToProductRequestDTO(Product product) {
        return modelMapper.map(product, ProductRequestDto.class);
    }

    // ProductRequestDTO → Product
    public Product convertToProduct(ProductRequestDto dto) {
        return modelMapper.map(dto, Product.class);
    }

    // Product → ProductResponseDTO
    public ProductResponseDTO convertToProductResponseDTO(Product product) {
        return modelMapper.map(product, ProductResponseDTO.class);
    }

   


    // ProductImageDTO → ProductImage
    public ProductImage convertToProductImage(ProductImageDTO dto) {
        return ProductImage.builder()
                .imageUrl(dto.getImageUrl())
                .isPrimary(dto.getIsPrimary()) // ✅ Ensures value is copied
                .build();
    }

}
