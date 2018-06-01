package com.powerreviews.project.controller;

import com.powerreviews.project.restaurant.RestaurantEntity;
import com.powerreviews.project.restaurant.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This is the entry point to the application
 * In this controller, implement the methods listed in the readme
 */
@RestController
public class ReviewController {
    private final RestaurantRepository restaurantRepository;

    public ReviewController(@Autowired RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @ResponseBody
    @RequestMapping(value = "/restaurant/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestaurantEntity> get(@PathVariable String id) {
        RestaurantEntity restaurant = restaurantRepository.findById(id).orElse(null);
        return new ResponseEntity<>(restaurant, new HttpHeaders(), restaurant == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }
}
