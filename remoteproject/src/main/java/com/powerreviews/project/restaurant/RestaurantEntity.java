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

    private String latitude;

    private String longitude;

    public RestaurantEntity(){}

    public RestaurantEntity(String name, String type, String latitude, String longitude) {
        this.name = name;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
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
                ", lat='" + latitude + '\'' +
                ", long='" + longitude + '\'' +
                '}';
    }
}
