package com.smartcity.smartcityguide.repository;

import com.smartcity.smartcityguide.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findByCity(String city);

    List<Restaurant> findByCuisine(String cuisine);

    List<Restaurant> findByRestaurantNameContainingIgnoreCase(String restaurantName);

    List<Restaurant> findByRatingGreaterThanEqual(Double rating);

}