package com.smartcity.smartcityguide.service.impl;

import com.smartcity.smartcityguide.entity.Attraction;
import com.smartcity.smartcityguide.exception.ResourceNotFoundException;
import com.smartcity.smartcityguide.repository.AttractionRepository;
import com.smartcity.smartcityguide.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttractionServiceImpl implements AttractionService {

    @Autowired
    private AttractionRepository repository;

    @Override
    public Attraction addAttraction(Attraction attraction) {
        return repository.save(attraction);
    }

    @Override
    public Attraction updateAttraction(Long id, Attraction attraction) {

        Attraction existing = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Attraction not found with id: " + id));

        existing.setPlaceName(attraction.getPlaceName());
        existing.setCity(attraction.getCity());
        existing.setDescription(attraction.getDescription());
        existing.setImageUrl(attraction.getImageUrl());
        existing.setTimings(attraction.getTimings());
        existing.setRating(attraction.getRating());

        return repository.save(existing);
    }

    @Override
    public void deleteAttraction(Long id) {

        Attraction attraction = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Attraction not found with id: " + id));

        repository.delete(attraction);
    }

    @Override
    public Attraction getAttractionById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Attraction not found with id: " + id));
    }

    @Override
    public List<Attraction> getAllAttractions() {
        return repository.findAll();
    }

    @Override
    public List<Attraction> getAttractionsByCity(String city) {
        return repository.findByCity(city);
    }

    @Override
    public List<Attraction> searchAttractionByName(String name) {
        return repository.findByPlaceNameContainingIgnoreCase(name);
    }

    @Override
    public List<Attraction> getAttractionsByRating(Double rating) {
        return repository.findByRatingGreaterThanEqual(rating);
    }
}