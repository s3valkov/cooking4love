package org.s3valkov.cooking4love.domain.models.view;

public class RestaurantViewModel {
    private String name;
    private String location;
    private double rate;

    public RestaurantViewModel(){
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

}
