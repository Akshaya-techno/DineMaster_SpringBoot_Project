/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
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
public class ChefJpaService implements ChefRepository {

    @Autowired
    private ChefJpaRepository chefJpaRepository;

    @Autowired
    private RestaurantJpaRepository restaurantJpaRepository;

    @Override
    public List<Chef> getChefs() {
        List<Chef> chefList = chefJpaRepository.findAll();
        return new ArrayList<>(chefList);
    }

    @Override
    public Chef addChef(Chef chef) {
        if (chef.getRestaurant() != null) {
            int restaurantId = chef.getRestaurant().getId();
            Restaurant restaurant = getRestaurantById(restaurantId);
            chef.setRestaurant(restaurant);
        }

        return chefJpaRepository.save(chef);
    }

    @Override
    public Chef getChefById(int chefId) {
        return chefJpaRepository.findById(chefId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Chef updateChef(int chefId, Chef chef) {
        Chef existingChef = getChefById(chefId);

        if (chef.getFirstName() != null) {
            existingChef.setFirstName(chef.getFirstName());
        }
        if (chef.getLastName() != null) {
            existingChef.setLastName(chef.getLastName());
        }
        if (chef.getExpertise() != null) {
            existingChef.setExpertise(chef.getExpertise());
        }
        if (chef.getExperienceYears() != 0) {
            existingChef.setExperienceYears(chef.getExperienceYears());
        }
        if (chef.getRestaurant() != null) {
            int restaurantId = chef.getRestaurant().getId();
            Restaurant restaurant = getRestaurantById(restaurantId);
            existingChef.setRestaurant(restaurant);
        }

        return chefJpaRepository.save(existingChef);
    }

    @Override
    public void deleteChef(int chefId) {
        Chef chef = getChefById(chefId);
        chefJpaRepository.delete(chef);
    }


    public Restaurant getChefRestaurant(int chefId) {
    Chef chef = chefJpaRepository.findById(chefId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    Restaurant restaurant = chef.getRestaurant();
    return restaurant;
    }

}