package org.s3valkov.cooking4love.domain.models.service;


import java.util.List;

public class CategoryServiceModel extends BaseServiceModel {
    private String name;
    private List<RecipeServiceModel> recipes;

    public CategoryServiceModel(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RecipeServiceModel> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RecipeServiceModel> recipes) {
        this.recipes = recipes;
    }
}
