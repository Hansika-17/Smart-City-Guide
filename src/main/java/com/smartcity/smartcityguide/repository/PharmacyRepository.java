package com.smartcity.smartcityguide.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartcity.smartcityguide.entity.Pharmacy;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {

    List<Pharmacy> findByCity(String city);

    List<Pharmacy> findByPharmacyNameContainingIgnoreCase(String pharmacyName);

}