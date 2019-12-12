package org.s3valkov.cooking4love.domain.models.binding;

import org.s3valkov.cooking4love.domain.entities.Restaurant;

public class CommentCreateBindingModel {
    private String author;
    private String description;
    private Restaurant restaurant;

    public CommentCreateBindingModel(){
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
