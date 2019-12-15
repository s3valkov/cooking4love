package org.s3valkov.cooking4love.service;

import org.s3valkov.cooking4love.domain.models.service.RecipeServiceModel;

import java.util.List;

public interface RecipeService {

    RecipeServiceModel createRecipe(RecipeServiceModel recipeServiceModel);

    RecipeServiceModel findRecipeByName(String name);

    List<RecipeServiceModel> findAllRecipes();

    RecipeServiceModel findRecipeById(String id);


}
