package org.s3valkov.cooking4love.domain.models.view;


public class CommentViewModel {
    private CategoryViewModel author;
    private CategoryViewModel description;
    private CategoryViewModel restaurantViewModel;

    public CommentViewModel(){}

    public CategoryViewModel getAuthor() {
        return author;
    }

    public void setAuthor(CategoryViewModel author) {
        this.author = author;
    }

    public CategoryViewModel getDescription() {
        return description;
    }

    public void setDescription(CategoryViewModel description) {
        this.description = description;
    }

    public CategoryViewModel getRestaurantViewModel() {
        return restaurantViewModel;
    }

    public void setRestaurantViewModel(CategoryViewModel restaurantViewModel) {
        this.restaurantViewModel = restaurantViewModel;
    }
}
