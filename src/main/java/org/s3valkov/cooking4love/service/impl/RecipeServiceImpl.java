package org.s3valkov.cooking4love.service.impl;

import org.modelmapper.ModelMapper;
import org.s3valkov.cooking4love.domain.entities.Recipe;
import org.s3valkov.cooking4love.domain.models.service.RecipeServiceModel;
import org.s3valkov.cooking4love.error.Constants;
import org.s3valkov.cooking4love.error.exceptions.RecipeNotFoundException;
import org.s3valkov.cooking4love.repository.RecipeRepository;
import org.s3valkov.cooking4love.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl  implements RecipeService {
    private final ModelMapper modelMapper;
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(ModelMapper modelMapper, RecipeRepository recipeRepository) {
        this.modelMapper = modelMapper;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public RecipeServiceModel createRecipe(RecipeServiceModel recipeServiceModel) {
        Recipe recipe = this.modelMapper.map(recipeServiceModel, Recipe.class);
        System.out.println();
        return this.modelMapper.map(this.recipeRepository.saveAndFlush(recipe), RecipeServiceModel.class);
    }

    @Override
    public RecipeServiceModel findRecipeByName(String name) {
        return this.recipeRepository.findByName(name)
                .map(r -> this.modelMapper.map(r, RecipeServiceModel.class))
                .orElseThrow(() -> new RecipeNotFoundException(Constants.RECIPE_NOT_FOUND));
    }

    @Override
    public List<RecipeServiceModel> findAllRecipes() {
        return this.recipeRepository.findAllAndOrderByTime()
                .stream()
                .map(r -> this.modelMapper.map(r, RecipeServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public RecipeServiceModel findRecipeById(String id) {
        return this.recipeRepository.findById(id)
                .map(r -> this.modelMapper.map(r, RecipeServiceModel.class))
                .orElseThrow(() -> new RecipeNotFoundException(Constants.RECIPE_NOT_FOUND));
    }

}
