package com.smartcity.smartcityguide.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartcity.smartcityguide.entity.EmergencyContact;

public interface EmergencyContactRepository extends JpaRepository<EmergencyContact, Long> {

    List<EmergencyContact> findByCity(String city);

    List<EmergencyContact> findByServiceNameContainingIgnoreCase(String serviceName);

}