package com.product_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDTO {
	 private Long id;
	    private String name;
	    private String primaryImageUrl;  // either a separate field in Product or queried
	    private Float price;
}
