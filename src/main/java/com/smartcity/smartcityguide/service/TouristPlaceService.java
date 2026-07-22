package com.smartcity.smartcityguide.service;

import com.smartcity.smartcityguide.entity.TouristPlace;

import java.util.List;

public interface TouristPlaceService {

    TouristPlace addTouristPlace(TouristPlace touristPlace);

    TouristPlace updateTouristPlace(Long id, TouristPlace touristPlace);

    void deleteTouristPlace(Long id);

    TouristPlace getTouristPlaceById(Long id);

    List<TouristPlace> getAllTouristPlaces();

    List<TouristPlace> getTouristPlacesByCity(String city);

    List<TouristPlace> searchTouristPlaceByName(String name);

    List<TouristPlace> getTouristPlacesByRating(Double rating);
}