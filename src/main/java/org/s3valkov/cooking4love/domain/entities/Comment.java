package org.s3valkov.cooking4love.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {
    private String author;
    private String description;
    private String restaurant;

    public Comment(){
    }

    @Column(name = "author", nullable = false)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "restaurant", nullable = false)
    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String  restaurant) {
        this.restaurant = restaurant;
    }
}
