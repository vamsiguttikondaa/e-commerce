package com.product_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductImageDTO {
	
	private String imageUrl;
	@JsonProperty("isPrimary")
    private Boolean isPrimary;
    
}
