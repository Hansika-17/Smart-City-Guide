package com.smartcity.smartcityguide.repository;

import com.smartcity.smartcityguide.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

    List<Hospital> findByCity(String city);

    List<Hospital> findByHospitalNameContainingIgnoreCase(String hospitalName);

}