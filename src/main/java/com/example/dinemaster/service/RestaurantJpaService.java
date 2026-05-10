/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * 
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.dinemaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.dinemaster.model.*;
import com.example.dinemaster.repository.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantJpaService implements RestaurantRepository {

    @Autowired
    private RestaurantJpaRepository restaurantJpaRepository;

    @Override
    public ArrayList<Restaurant> getRestaurants() {
        List<Restaurant> restaurantList = restaurantJpaRepository.findAll();
        return new ArrayList<>(restaurantList);
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantJpaRepository.save(restaurant);
    }

    @Override
    public Restaurant getRestaurantById(int restaurantId) {
        return restaurantJpaRepository.findById(restaurantId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Restaurant updateRestaurant(int restaurantId, Restaurant restaurant) {
        Restaurant existingRestaurant = getRestaurantById(restaurantId);

        if (restaurant.getName() != null) {
            existingRestaurant.setName(restaurant.getName());
        }
        if (restaurant.getAddress() != null) {
            existingRestaurant.setAddress(restaurant.getAddress());
        }
        if (restaurant.getCuisineType() != null) {
            existingRestaurant.setCuisineType(restaurant.getCuisineType());
        }
        if (restaurant.getRating() != 0) {
            existingRestaurant.setRating(restaurant.getRating());
        }

        return restaurantJpaRepository.save(existingRestaurant);
    }

    @Override
    public void deleteRestaurant(int restaurantId) {
        Restaurant restaurant = getRestaurantById(restaurantId);
        restaurantJpaRepository.delete(restaurant);
    }
}