package com.smartcity.smartcityguide.service;

import com.smartcity.smartcityguide.entity.Restaurant;

import java.util.List;

public interface RestaurantService {

    Restaurant addRestaurant(Restaurant restaurant);

    Restaurant updateRestaurant(Long id, Restaurant restaurant);

    void deleteRestaurant(Long id);

    Restaurant getRestaurantById(Long id);

    List<Restaurant> getAllRestaurants();

    List<Restaurant> getRestaurantsByCity(String city);

    List<Restaurant> getRestaurantsByCuisine(String cuisine);

    List<Restaurant> searchRestaurantByName(String restaurantName);

    List<Restaurant> getRestaurantsByRating(Double rating);

    List<Restaurant> getRestaurantsByCityAndPriceRange(String city, String priceRange);

    List<Restaurant> getRestaurantsByPriceRange(String priceRange);

    List<Restaurant> getRestaurantsByBestFor(String bestFor);

List<Restaurant> getRestaurantsByCityAndBestFor(String city, String bestFor);

List<Restaurant> getRestaurantsByCityAndPriceRangeAndBestFor(
        String city,
        String priceRange,
        String bestFor
);
}