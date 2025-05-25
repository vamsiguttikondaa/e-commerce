package com.product_service.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDetailResponseDTO {
    private Long id;
    private String name;
    private String description;
    private Float price;
    private String sku;
    private Integer quantity;
    private String primaryImageUrl;
    private Long categoryId;
    private List<ProductImageResponseDTO> images;
}