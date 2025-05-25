package com.category_service.helper;

import org.springframework.stereotype.Component;

import com.category_service.dto.CategoryRequestDTO;
import com.category_service.dto.CategoryResponseDTO;
import com.category_service.entities.Category;

@Component
public class DtoConverter {

    // Convert from Request DTO to Entity
    public Category toEntity(CategoryRequestDTO dto) {
        Category category = new Category();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        category.setImageUrl(dto.getImageUrl());
        return category;
    }

    // Convert from Entity to Response DTO
    public CategoryResponseDTO toResponseDTO(Category category) {
        CategoryResponseDTO dto = new CategoryResponseDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        dto.setImageUrl(category.getImageUrl());
        return dto;
    }

    // Optional: Convert from Request DTO to existing entity (for update)
    public void updateEntityFromDto(CategoryRequestDTO dto, Category category) {
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        category.setImageUrl(dto.getImageUrl());
    }
}
