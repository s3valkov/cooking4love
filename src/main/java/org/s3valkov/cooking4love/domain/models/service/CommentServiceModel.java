package org.s3valkov.cooking4love.domain.models.service;

public class CommentServiceModel extends BaseServiceModel {
    private String author;
    private String description;
    private RestaurantServiceModel restaurant;

    public CommentServiceModel(){
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

    public RestaurantServiceModel getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantServiceModel restaurant) {
        this.restaurant = restaurant;
    }
}
