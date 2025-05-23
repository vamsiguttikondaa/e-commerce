package com.product_service.dto;

import java.util.List;

public class ProductDetailResponseDTO {
	private Long id;
    private String name;
    private String description;
    private float price;
    private List<ProductImageDTO> images;
}
