package com.smartcity.smartcityguide.service.impl;

import com.smartcity.smartcityguide.entity.Restaurant;
import com.smartcity.smartcityguide.exception.ResourceNotFoundException;
import com.smartcity.smartcityguide.repository.RestaurantRepository;
import com.smartcity.smartcityguide.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Long id, Restaurant restaurant) {

        Restaurant existingRestaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + id));

        existingRestaurant.setRestaurantName(restaurant.getRestaurantName());
        existingRestaurant.setCity(restaurant.getCity());
        existingRestaurant.setAddress(restaurant.getAddress());
        existingRestaurant.setDescription(restaurant.getDescription());
        existingRestaurant.setContactNumber(restaurant.getContactNumber());
        existingRestaurant.setEmail(restaurant.getEmail());
        existingRestaurant.setImageUrl(restaurant.getImageUrl());
        existingRestaurant.setCuisine(restaurant.getCuisine());
        existingRestaurant.setRating(restaurant.getRating());
        existingRestaurant.setPriceRange(restaurant.getPriceRange());
existingRestaurant.setBestFor(restaurant.getBestFor());
existingRestaurant.setAverageCost(restaurant.getAverageCost());
existingRestaurant.setOpeningHours(restaurant.getOpeningHours());

        return restaurantRepository.save(existingRestaurant);
    }

    @Override
    public void deleteRestaurant(Long id) {

        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + id));

        restaurantRepository.delete(restaurant);
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + id));
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> getRestaurantsByCity(String city) {
        return restaurantRepository.findByCity(city);
    }

    @Override
    public List<Restaurant> getRestaurantsByCuisine(String cuisine) {
        return restaurantRepository.findByCuisine(cuisine);
    }

    @Override
    public List<Restaurant> searchRestaurantByName(String restaurantName) {
        return restaurantRepository.findByRestaurantNameContainingIgnoreCase(restaurantName);
    }

    @Override
    public List<Restaurant> getRestaurantsByRating(Double rating) {
        return restaurantRepository.findByRatingGreaterThanEqual(rating);
    }

    @Override
public List<Restaurant> getRestaurantsByCityAndPriceRange(String city, String priceRange) {
    return restaurantRepository.findByCityAndPriceRange(city, priceRange);
}

@Override
public List<Restaurant> getRestaurantsByPriceRange(String priceRange) {
    return restaurantRepository.findByPriceRange(priceRange);
}
}