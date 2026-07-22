package com.smartcity.smartcityguide.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartcity.smartcityguide.entity.FireStation;
import com.smartcity.smartcityguide.exception.ResourceNotFoundException;
import com.smartcity.smartcityguide.repository.FireStationRepository;
import com.smartcity.smartcityguide.service.FireStationService;

@Service
public class FireStationServiceImpl implements FireStationService {

    @Autowired
    private FireStationRepository fireStationRepository;

    @Override
    public FireStation addFireStation(FireStation fireStation) {
        return fireStationRepository.save(fireStation);
    }

    @Override
    public FireStation updateFireStation(Long id, FireStation fireStation) {

        FireStation existing = fireStationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fire Station not found with id: " + id));

        existing.setStationName(fireStation.getStationName());
        existing.setCity(fireStation.getCity());
        existing.setAddress(fireStation.getAddress());
        existing.setContactNumber(fireStation.getContactNumber());
        existing.setEmail(fireStation.getEmail());
        existing.setImageUrl(fireStation.getImageUrl());

        return fireStationRepository.save(existing);
    }

    @Override
    public void deleteFireStation(Long id) {

        FireStation station = fireStationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fire Station not found with id: " + id));

        fireStationRepository.delete(station);
    }

    @Override
    public FireStation getFireStationById(Long id) {

        return fireStationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fire Station not found with id: " + id));
    }

    @Override
    public List<FireStation> getAllFireStations() {
        return fireStationRepository.findAll();
    }

    @Override
    public List<FireStation> getFireStationsByCity(String city) {
        return fireStationRepository.findByCity(city);
    }

    @Override
    public List<FireStation> searchFireStationByName(String stationName) {
        return fireStationRepository.findByStationNameContainingIgnoreCase(stationName);
    }
}