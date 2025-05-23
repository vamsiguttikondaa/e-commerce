package com.product_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductImageResponseDTO {
	private long id;
	private long productId;
	private String imageUrl;
    private boolean isPrimary;
}
