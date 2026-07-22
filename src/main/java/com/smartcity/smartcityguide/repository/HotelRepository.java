package com.smartcity.smartcityguide.repository;

import com.smartcity.smartcityguide.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    List<Hotel> findByCity(String city);

    List<Hotel> findByCategory(String category);

    List<Hotel> findByHotelNameContainingIgnoreCase(String hotelName);

    List<Hotel> findByRatingGreaterThanEqual(Double rating);

    List<Hotel> findByPriceRange(String priceRange);

List<Hotel> findByBestForContainingIgnoreCase(String bestFor);

List<Hotel> findByCityAndPriceRange(String city, String priceRange);

List<Hotel> findByCityAndBestForContainingIgnoreCase(String city, String bestFor);

List<Hotel> findByCityAndPriceRangeAndBestForContainingIgnoreCase(
        String city,
        String priceRange,
        String bestFor
);

}