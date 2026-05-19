package com.eventhub.service.impl;

import com.eventhub.dto.category.CategoryRequestDTO;
import com.eventhub.dto.category.CategoryResponseDTO;
import com.eventhub.entity.Category;
import com.eventhub.exception.BusinessException;
import com.eventhub.exception.ResourceNotFoundException;
import com.eventhub.repository.CategoryRepository;
import com.eventhub.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.eventhub.exception.ErrorMessages.*;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponseDTO> findAll() {
        return categoryRepository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    public CategoryResponseDTO findById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(CATEGORY_NOT_FOUND));
        return toResponse(category);
    }

    @Override
    public CategoryResponseDTO create(CategoryRequestDTO request) {
        if (categoryRepository.existsByNameIgnoreCase(request.name())) {
            throw new BusinessException(CATEGORY_ALREADY_EXISTS);
        }

        Category category = Category.builder()
                .name(request.name())
                .description(request.description())
                .build();

        return toResponse(categoryRepository.save(category));
    }

    @Override
    public CategoryResponseDTO update(Long id, CategoryRequestDTO request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(CATEGORY_NOT_FOUND));

        category.setName(request.name());
        category.setDescription(request.description());
        return toResponse(categoryRepository.save(category));
    }

    @Override
    public void delete(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new ResourceNotFoundException(CATEGORY_NOT_FOUND);
        }
        categoryRepository.deleteById(id);
    }

    private CategoryResponseDTO toResponse(Category category) {
        return new CategoryResponseDTO(category.getId(), category.getName(), category.getDescription());
    }
}
