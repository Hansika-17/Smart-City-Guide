package com.smartcity.smartcityguide.service;

import java.util.List;

import com.smartcity.smartcityguide.entity.PoliceStation;

public interface PoliceStationService {

    PoliceStation addPoliceStation(PoliceStation policeStation);

    PoliceStation updatePoliceStation(Long id, PoliceStation policeStation);

    void deletePoliceStation(Long id);

    PoliceStation getPoliceStationById(Long id);

    List<PoliceStation> getAllPoliceStations();

    List<PoliceStation> getPoliceStationsByCity(String city);

    List<PoliceStation> searchPoliceStationByName(String stationName);

}