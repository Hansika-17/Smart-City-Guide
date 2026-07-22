package com.smartcity.smartcityguide.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartcity.smartcityguide.entity.PoliceStation;

@Repository
public interface PoliceStationRepository extends JpaRepository<PoliceStation, Long> {

    List<PoliceStation> findByCity(String city);

    List<PoliceStation> findByStationNameContainingIgnoreCase(String stationName);

}