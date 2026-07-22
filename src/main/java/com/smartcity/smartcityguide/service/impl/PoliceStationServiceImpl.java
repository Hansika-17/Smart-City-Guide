package com.smartcity.smartcityguide.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartcity.smartcityguide.entity.PoliceStation;
import com.smartcity.smartcityguide.exception.ResourceNotFoundException;
import com.smartcity.smartcityguide.repository.PoliceStationRepository;
import com.smartcity.smartcityguide.service.PoliceStationService;

@Service
public class PoliceStationServiceImpl implements PoliceStationService {

    @Autowired
    private PoliceStationRepository policeStationRepository;

    @Override
    public PoliceStation addPoliceStation(PoliceStation policeStation) {
        return policeStationRepository.save(policeStation);
    }

    @Override
    public PoliceStation updatePoliceStation(Long id, PoliceStation policeStation) {

        PoliceStation existing = policeStationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Police Station not found with id: " + id));

        existing.setStationName(policeStation.getStationName());
        existing.setCity(policeStation.getCity());
        existing.setAddress(policeStation.getAddress());
        existing.setContactNumber(policeStation.getContactNumber());
        existing.setEmail(policeStation.getEmail());
        existing.setImageUrl(policeStation.getImageUrl());

        return policeStationRepository.save(existing);
    }

    @Override
    public void deletePoliceStation(Long id) {

        PoliceStation station = policeStationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Police Station not found with id: " + id));

        policeStationRepository.delete(station);
    }

    @Override
    public PoliceStation getPoliceStationById(Long id) {

        return policeStationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Police Station not found with id: " + id));
    }

    @Override
    public List<PoliceStation> getAllPoliceStations() {
        return policeStationRepository.findAll();
    }

    @Override
    public List<PoliceStation> getPoliceStationsByCity(String city) {
        return policeStationRepository.findByCity(city);
    }

    @Override
    public List<PoliceStation> searchPoliceStationByName(String stationName) {
        return policeStationRepository.findByStationNameContainingIgnoreCase(stationName);
    }
}