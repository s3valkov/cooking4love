package org.s3valkov.cooking4love.domain.models.binding;

import org.s3valkov.cooking4love.domain.entities.Comment;

import java.util.List;

public class RestaurantCreateBindingModel {
    private String name;
    private String location;
    private double rate;
    private List<Comment> comments;

    public RestaurantCreateBindingModel(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
