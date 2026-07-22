package com.smartcity.smartcityguide.service;

import java.util.List;

import com.smartcity.smartcityguide.entity.FireStation;

public interface FireStationService {

    FireStation addFireStation(FireStation fireStation);

    FireStation updateFireStation(Long id, FireStation fireStation);

    void deleteFireStation(Long id);

    FireStation getFireStationById(Long id);

    List<FireStation> getAllFireStations();

    List<FireStation> getFireStationsByCity(String city);

    List<FireStation> searchFireStationByName(String stationName);

}