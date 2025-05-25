package com.product_service.utility;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.product_service.dto.ProductDetailResponseDTO;
import com.product_service.dto.ProductImageDTO;
import com.product_service.dto.ProductImageResponseDTO;
import com.product_service.dto.ProductRequestDto;
import com.product_service.dto.ProductResponseDTO;
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
                .isPrimary(dto.getIsPrimary())
                .build();
    }

    // ProductImage → ProductImageResponseDTO
    public ProductImageResponseDTO convertToProductImageResponseDTO(ProductImage image) {
        return ProductImageResponseDTO.builder()
                .id(image.getId())
                .imageUrl(image.getImageUrl())
                .isPrimary(image.isPrimary())
                .build();
    }

    // Product → ProductDetailResponseDTO
    public ProductDetailResponseDTO convertToProductDetailResponseDTO(Product product) {
        List<ProductImageResponseDTO> imageDTOs = null;

        if (product.getImages() != null) {
            imageDTOs = product.getImages().stream()
                    .map(this::convertToProductImageResponseDTO)
                    .collect(Collectors.toList());
        }

        return ProductDetailResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .sku(product.getSku())
                .quantity(product.getQuantity())
                .primaryImageUrl(product.getPrimaryImageUrl())
                .categoryId(product.getCategoryId())
                .images(imageDTOs)
                .build();
    }
}
