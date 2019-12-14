package org.s3valkov.cooking4love.service.impl;

import org.modelmapper.ModelMapper;
import org.s3valkov.cooking4love.domain.entities.Category;
import org.s3valkov.cooking4love.domain.models.service.CategoryServiceModel;
import org.s3valkov.cooking4love.error.exceptions.CategoryNotFoundException;
import org.s3valkov.cooking4love.error.Constants;
import org.s3valkov.cooking4love.repository.CategoryRepository;
import org.s3valkov.cooking4love.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryServiceModel createCategory(CategoryServiceModel categoryServiceModel) {
        Category category = this.modelMapper.map(categoryServiceModel, Category.class);
        return this.modelMapper.map(this.categoryRepository.saveAndFlush(category), CategoryServiceModel.class);
    }

    @Override
    public CategoryServiceModel findByName(String name) {
        return this.categoryRepository.findByName(name)
                .map(c -> this.modelMapper.map(c, CategoryServiceModel.class))
                .orElseThrow(() -> new CategoryNotFoundException(Constants.CATEGORY_NOT_FOUND));
    }

    @Override
    public List<CategoryServiceModel> findAllCategories() {
        return this.categoryRepository.findAll()
                .stream()
                .map(c -> this.modelMapper.map(c, CategoryServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryServiceModel findCategoryById(String id) {
        return this.categoryRepository.findById(id)
                .map(c -> this.modelMapper.map(c, CategoryServiceModel.class))
                .orElseThrow(() -> new CategoryNotFoundException(Constants.CATEGORY_NOT_FOUND));
    }
}
