package com.category_service.service;

import java.util.List;

import com.category_service.dto.CategoryRequestDTO;
import com.category_service.dto.CategoryResponseDTO;

public interface CategoryService {

    CategoryResponseDTO createCategory(CategoryRequestDTO dto);

    CategoryResponseDTO getCategoryById(Long id);

    List<CategoryResponseDTO> getAllCategories();

    CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO dto);

    void deleteCategory(Long id);

    boolean isValidCategory(Long id);
}
