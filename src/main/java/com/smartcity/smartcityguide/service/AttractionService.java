package com.smartcity.smartcityguide.service;

import com.smartcity.smartcityguide.entity.Attraction;

import java.util.List;

public interface AttractionService {

    Attraction addAttraction(Attraction attraction);

    Attraction updateAttraction(Long id, Attraction attraction);

    void deleteAttraction(Long id);

    Attraction getAttractionById(Long id);

    List<Attraction> getAllAttractions();

    List<Attraction> getAttractionsByCity(String city);

    List<Attraction> searchAttractionByName(String name);

    List<Attraction> getAttractionsByRating(Double rating);
}