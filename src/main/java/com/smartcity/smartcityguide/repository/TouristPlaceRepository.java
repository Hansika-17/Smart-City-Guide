package com.smartcity.smartcityguide.repository;

import com.smartcity.smartcityguide.entity.TouristPlace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TouristPlaceRepository extends JpaRepository<TouristPlace, Long> {

    List<TouristPlace> findByCity(String city);

    List<TouristPlace> findByPlaceNameContainingIgnoreCase(String placeName);

    List<TouristPlace> findByRatingGreaterThanEqual(Double rating);
}