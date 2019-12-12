package org.s3valkov.cooking4love.service;

import org.s3valkov.cooking4love.domain.models.service.CategoryServiceModel;

import java.util.List;

public interface CategoryService {

    CategoryServiceModel createCategory(CategoryServiceModel categoryServiceModel);

    CategoryServiceModel findByName(String name);

    List<CategoryServiceModel> findAllCategories();

    CategoryServiceModel findCategoryById(String id);

}
