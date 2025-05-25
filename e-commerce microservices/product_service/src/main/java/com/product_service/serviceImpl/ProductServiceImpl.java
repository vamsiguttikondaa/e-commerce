package com.product_service.serviceImpl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product_service.dto.ProductDetailResponseDTO;
import com.product_service.dto.ProductImageResponseDTO;
import com.product_service.dto.ProductRequestDto;
import com.product_service.dto.ProductResponseDTO;
import com.product_service.entities.Product;
import com.product_service.repository.ProductRepo;
import com.product_service.service.ProductService;
import com.product_service.utility.DtoConverter;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepo proRepo;
	@Autowired
	private DtoConverter dtoConverter;

	@Override
	public ProductResponseDTO createProduct(ProductRequestDto dto) {
		Product product=dtoConverter.convertToProduct(dto);
		Product savedProduct=proRepo.save(product);
		return dtoConverter.convertToProductResponseDTO(savedProduct);
	}

	@Override
	public ProductDetailResponseDTO getProductById(Long id) {
		 Product product = proRepo.findById(id)
			        .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

			    return dtoConverter.convertToProductDetailResponseDTO(product);
	}

	@Override
	public List<ProductResponseDTO> getAllProducts() {
				List<Product> products	=proRepo.findAll();
				List<ProductResponseDTO> dto=products.stream().map(prod->dtoConverter.convertToProductResponseDTO(prod)).collect(Collectors.toList());
		return dto;
	}

	@Override
	public void deleteProduct(Long id) {
		Product product = proRepo.findById(id)
		        .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

		    proRepo.delete(product);
		
	}

	@Override
	public boolean isValid(Long id) {
		Product product=proRepo.findById(id).orElseThrow(()->new RuntimeException("product id not valid"+id));
		if(product!=null) {
			return true;
		}
		return false;
	}

	@Override
	public void setPrimary(Product existingProduct,String url) {
		existingProduct.setPrimaryImageUrl(url);
		proRepo.save(existingProduct);
		return;
		
	}

	@Override
	public Product getProductEntityById(Long id) {
		return proRepo.findById(id)
		        .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
	}
	@Override
	public ProductResponseDTO updateProduct(Long id, ProductRequestDto dto) {
	    Product existingProduct = proRepo.findById(id)
	        .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

	    // Update fields manually
	    existingProduct.setName(dto.getName());
	    existingProduct.setDescription(dto.getDescription());
	    existingProduct.setPrice(dto.getPrice());
	    existingProduct.setSku(dto.getSku());
	    existingProduct.setQuantity(dto.getQuantity());
	    existingProduct.setCategoryId(dto.getCategoryId());

	    Product updated = proRepo.save(existingProduct);
	    return dtoConverter.convertToProductResponseDTO(updated);
	}


}
