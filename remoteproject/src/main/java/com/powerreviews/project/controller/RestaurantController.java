package com.powerreviews.project.controller;

import com.powerreviews.project.persistence.RestaurantEntity;
import com.powerreviews.project.persistence.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;

    public RestaurantController(@Autowired RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @ResponseBody
    @RequestMapping(value = "/restaurant/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestaurantEntity> get(@PathVariable Integer id) {
        RestaurantEntity restaurant = restaurantRepository.findById(id).orElse(null);
        return new ResponseEntity<>(restaurant, new HttpHeaders(), restaurant == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // Could we build an endpoint to search for a restaurant based on a partial match of its name?
    // What would the endpoint signature be?
    // Where would the logic for the search go?

    @ResponseBody
    @RequestMapping(value = "/restaurant", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestaurantEntity> post(@RequestBody RestaurantEntity restaurant) {
        // What kind of validation can be put here and how?
        // What should happen if this is a duplicate restaurant?
        // How do we determine if it is a duplicate?
        // Where should that determination be made?
        int id = restaurantRepository.maxId() + 1;
        restaurant.setId(id);
        restaurantRepository.save(restaurant);
        return new ResponseEntity<>(restaurant, new HttpHeaders(), HttpStatus.CREATED);
    }

    @ResponseBody
    @RequestMapping(value = "/restaurant", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestaurantEntity> put(@RequestBody RestaurantEntity restaurant) {
        // What kind of validation can be put here and how?
        RestaurantEntity updated = restaurantRepository.findById(restaurant.getId()).orElse(null);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // What other pattern could be put in place as a way to update the restaurant's attributes?
        updated.setLatitude(restaurant.getLatitude());
        updated.setLongitude(restaurant.getLongitude());
        updated.setName(restaurant.getName());
        updated.setType(restaurant.getType());
        restaurantRepository.save(updated);
        return new ResponseEntity<>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/restaurant/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestaurantEntity> delete(@PathVariable Integer id) {
        // What should happen if the restaurant doesn't exist?
        restaurantRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
