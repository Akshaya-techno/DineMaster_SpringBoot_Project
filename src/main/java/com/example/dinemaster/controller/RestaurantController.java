/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.dinemaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.example.dinemaster.model.*;
import com.example.dinemaster.service.RestaurantJpaService;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantJpaService restaurantJpaService;

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants() {
        return restaurantJpaService.getRestaurants();
    }

    @PostMapping("/restaurants")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantJpaService.addRestaurant(restaurant);
    }

    @GetMapping("/restaurants/{restaurantId}")
    public Restaurant getRestaurantById(@PathVariable int restaurantId) {
        return restaurantJpaService.getRestaurantById(restaurantId);
    }

    @PutMapping("/restaurants/{restaurantId}")
    public Restaurant updateRestaurant(@PathVariable int restaurantId, @RequestBody Restaurant restaurant) {
        return restaurantJpaService.updateRestaurant(restaurantId, restaurant);
    }

    @DeleteMapping("/restaurants/{restaurantId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRestaurant(@PathVariable int restaurantId) {
        restaurantJpaService.deleteRestaurant(restaurantId);
    }
}