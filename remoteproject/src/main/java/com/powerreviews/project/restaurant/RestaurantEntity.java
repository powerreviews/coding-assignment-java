package com.powerreviews.project.restaurant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RestaurantEntity {


    @Id
    private String name;

    @Column
    private String type;

    public RestaurantEntity(){}

    public RestaurantEntity(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RestaurantEntity{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
