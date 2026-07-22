package com.smartcity.smartcityguide.service.impl;

import com.smartcity.smartcityguide.entity.TouristPlace;
import com.smartcity.smartcityguide.exception.ResourceNotFoundException;
import com.smartcity.smartcityguide.repository.TouristPlaceRepository;
import com.smartcity.smartcityguide.service.TouristPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristPlaceServiceImpl implements TouristPlaceService {

    @Autowired
    private TouristPlaceRepository repository;

    @Override
    public TouristPlace addTouristPlace(TouristPlace touristPlace) {
        return repository.save(touristPlace);
    }

    @Override
    public TouristPlace updateTouristPlace(Long id, TouristPlace touristPlace) {

        TouristPlace existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tourist Place not found with id: " + id));

        existing.setPlaceName(touristPlace.getPlaceName());
        existing.setCity(touristPlace.getCity());
        existing.setDescription(touristPlace.getDescription());
        existing.setImageUrl(touristPlace.getImageUrl());
        existing.setTimings(touristPlace.getTimings());
        existing.setRating(touristPlace.getRating());

        return repository.save(existing);
    }

    @Override
    public void deleteTouristPlace(Long id) {

        TouristPlace place = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tourist Place not found with id: " + id));

        repository.delete(place);
    }

    @Override
    public TouristPlace getTouristPlaceById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tourist Place not found with id: " + id));
    }

    @Override
    public List<TouristPlace> getAllTouristPlaces() {
        return repository.findAll();
    }

    @Override
    public List<TouristPlace> getTouristPlacesByCity(String city) {
        return repository.findByCity(city);
    }

    @Override
    public List<TouristPlace> searchTouristPlaceByName(String name) {
        return repository.findByPlaceNameContainingIgnoreCase(name);
    }

    @Override
    public List<TouristPlace> getTouristPlacesByRating(Double rating) {
        return repository.findByRatingGreaterThanEqual(rating);
    }
}