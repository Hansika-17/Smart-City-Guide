package com.smartcity.smartcityguide.repository;

import com.smartcity.smartcityguide.entity.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttractionRepository extends JpaRepository<Attraction, Long> {

    List<Attraction> findByCity(String city);

    List<Attraction> findByPlaceNameContainingIgnoreCase(String placeName);

    List<Attraction> findByRatingGreaterThanEqual(Double rating);
}