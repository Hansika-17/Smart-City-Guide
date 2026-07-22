package com.smartcity.smartcityguide.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartcity.smartcityguide.entity.FireStation;

@Repository
public interface FireStationRepository extends JpaRepository<FireStation, Long> {

    List<FireStation> findByCity(String city);

    List<FireStation> findByStationNameContainingIgnoreCase(String stationName);

}