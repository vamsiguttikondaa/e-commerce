package com.category_service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.category_service.dto.CategoryRequestDTO;
import com.category_service.dto.CategoryResponseDTO;
import com.category_service.entities.Category;
import com.category_service.repository.CategoryRepo;
import com.category_service.service.CategoryService;
import com.category_service.helper.DtoConverter;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private DtoConverter dtoConverter;

    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO dto) {
        Category category = dtoConverter.toEntity(dto);
        Category saved = categoryRepo.save(category);
        return dtoConverter.toResponseDTO(saved);
    }

    @Override
    public CategoryResponseDTO getCategoryById(Long id) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        return dtoConverter.toResponseDTO(category);
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        return categoryRepo.findAll().stream()
                .map(dtoConverter::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO dto) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        dtoConverter.updateEntityFromDto(dto, category);
        Category updated = categoryRepo.save(category);
        return dtoConverter.toResponseDTO(updated);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        categoryRepo.delete(category);
    }

    @Override
    public boolean isValidCategory(Long id) {
        return categoryRepo.existsById(id);
    }
}
