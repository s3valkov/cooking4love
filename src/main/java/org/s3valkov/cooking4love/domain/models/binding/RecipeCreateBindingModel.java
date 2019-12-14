package org.s3valkov.cooking4love.domain.models.binding;

import org.s3valkov.cooking4love.domain.entities.Category;
import org.s3valkov.cooking4love.domain.entities.Level;

public class RecipeCreateBindingModel {
    private String name;
    private String author;
    private String category;
    private String ingridients;
    private String method;
    private Level level;
    private int time;

    public RecipeCreateBindingModel(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIngridients() {
        return ingridients;
    }

    public void setIngridients(String ingridients) {
        this.ingridients = ingridients;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
