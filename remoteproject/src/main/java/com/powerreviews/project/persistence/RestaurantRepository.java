package com.powerreviews.project.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<RestaurantEntity, Integer>{
    @Query("SELECT MAX(id) FROM restaurant")
    int maxId();
}
