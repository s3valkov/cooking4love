package org.s3valkov.cooking4love.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant extends BaseEntity{
    private String name;
    private String location;
    private double rate;
    private List<Comment> comments;

    public Restaurant(){
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "location", nullable = false)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "average_rate", nullable = false)
    public double getRate() {
        return rate;
    }

    public void setRate(double averageRate) {
        this.rate = averageRate;
    }

    @OneToMany(mappedBy = "restaurant")
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
