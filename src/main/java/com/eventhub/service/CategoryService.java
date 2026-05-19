package com.eventhub.service;

import com.eventhub.dto.category.CategoryRequestDTO;
import com.eventhub.dto.category.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDTO> findAll();
    CategoryResponseDTO findById(Long id);
    CategoryResponseDTO create(CategoryRequestDTO request);
    CategoryResponseDTO update(Long id, CategoryRequestDTO request);
    void delete(Long id);
}
