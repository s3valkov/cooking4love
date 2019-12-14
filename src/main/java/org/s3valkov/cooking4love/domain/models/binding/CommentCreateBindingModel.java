package org.s3valkov.cooking4love.domain.models.binding;

public class CommentCreateBindingModel {
    private String author;
    private String description;
    private String restaurant;

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

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }
}
