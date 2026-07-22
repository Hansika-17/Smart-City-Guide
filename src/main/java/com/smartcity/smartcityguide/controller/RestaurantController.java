package com.smartcity.smartcityguide.controller;

import com.smartcity.smartcityguide.entity.Restaurant;
import com.smartcity.smartcityguide.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@CrossOrigin(origins = "*")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;


    // Add Restaurant
    @PostMapping
    public ResponseEntity<Restaurant> addRestaurant(
            @Valid @RequestBody Restaurant restaurant) {

        return new ResponseEntity<>(
                restaurantService.addRestaurant(restaurant),
                HttpStatus.CREATED
        );
    }


    // Get All Restaurants
    @GetMapping
public ResponseEntity<List<Restaurant>> getRestaurants(
        @RequestParam(required = false) String city,
        @RequestParam(required = false) String priceRange) {

    if (city != null && priceRange != null) {
        return ResponseEntity.ok(
                restaurantService.getRestaurantsByCityAndPriceRange(city, priceRange)
        );
    }

    if (city != null) {
        return ResponseEntity.ok(
                restaurantService.getRestaurantsByCity(city)
        );
    }

    if (priceRange != null) {
        return ResponseEntity.ok(
                restaurantService.getRestaurantsByPriceRange(priceRange)
        );
    }

    return ResponseEntity.ok(
            restaurantService.getAllRestaurants()
    );
}


    // Get Restaurant By ID
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                restaurantService.getRestaurantById(id)
        );
    }


    // Update Restaurant
    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(
            @PathVariable Long id,
            @Valid @RequestBody Restaurant restaurant) {

        return ResponseEntity.ok(
                restaurantService.updateRestaurant(id, restaurant)
        );
    }


    // Delete Restaurant
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestaurant(
            @PathVariable Long id) {

        restaurantService.deleteRestaurant(id);

        return ResponseEntity.ok(
                "Restaurant deleted successfully"
        );
    }


    // Search by City
    @GetMapping("/city/{city}")
    public ResponseEntity<List<Restaurant>> getRestaurantsByCity(
            @PathVariable String city) {

        return ResponseEntity.ok(
                restaurantService.getRestaurantsByCity(city)
        );
    }


    // Search by Cuisine
    @GetMapping("/cuisine/{cuisine}")
    public ResponseEntity<List<Restaurant>> getRestaurantsByCuisine(
            @PathVariable String cuisine) {

        return ResponseEntity.ok(
                restaurantService.getRestaurantsByCuisine(cuisine)
        );
    }


    // Search by Name
    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> searchRestaurants(
            @RequestParam String name) {

        return ResponseEntity.ok(
                restaurantService.searchRestaurantByName(name)
        );
    }


    // Filter by Rating
    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<Restaurant>> getRestaurantsByRating(
            @PathVariable Double rating) {

        return ResponseEntity.ok(
                restaurantService.getRestaurantsByRating(rating)
        );
    }
}