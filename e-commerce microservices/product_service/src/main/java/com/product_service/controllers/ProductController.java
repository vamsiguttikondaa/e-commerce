package com.product_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product_service.dto.ProductRequestDto;
import com.product_service.dto.ProductResponseDTO;
import com.product_service.service.ProductService;
import com.product_service.utility.DtoConverter;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private DtoConverter dtoConverter;
    
    @Autowired
    private ProductService proService;

    @PostMapping("/")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDto dto) {
        return new ResponseEntity<>(proService.createProduct(dto), HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<ProductResponseDTO>> getProducts(){
    	return new ResponseEntity<>(proService.getAllProducts(),HttpStatus.OK);
    }
   
}