package org.s3valkov.cooking4love.domain.models.view;

public class CategoryViewModel {
    private String name;
    private int countOfRecipes;

    public CategoryViewModel(){
    }

    public String  getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountOfRecipes() {
        return countOfRecipes;
    }

    public void setCountOfRecipes(int countOfRecipes) {
        this.countOfRecipes = countOfRecipes;
    }
}
