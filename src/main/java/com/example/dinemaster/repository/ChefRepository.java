/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here

package com.example.dinemaster.repository;

import com.example.dinemaster.model.*;

import java.util.List;

public interface ChefRepository {

    List<Chef> getChefs();

    Chef addChef(Chef chef);

    Chef getChefById(int chefId);

    Chef updateChef(int chefId, Chef chef);

    void deleteChef(int chefId);

    Restaurant getChefRestaurant(int chefId);
}