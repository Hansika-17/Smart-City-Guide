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

}