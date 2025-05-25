package com.category_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.category_service.entities.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

}
