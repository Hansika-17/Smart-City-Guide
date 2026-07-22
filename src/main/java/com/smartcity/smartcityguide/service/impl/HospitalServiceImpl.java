package com.smartcity.smartcityguide.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartcity.smartcityguide.entity.Hospital;
import com.smartcity.smartcityguide.exception.ResourceNotFoundException;
import com.smartcity.smartcityguide.repository.HospitalRepository;
import com.smartcity.smartcityguide.service.HospitalService;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public Hospital addHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @Override
    public Hospital updateHospital(Long id, Hospital hospital) {

        Hospital existingHospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hospital not found with id: " + id));

        existingHospital.setHospitalName(hospital.getHospitalName());
        existingHospital.setCity(hospital.getCity());
        existingHospital.setAddress(hospital.getAddress());
        existingHospital.setContactNumber(hospital.getContactNumber());
        existingHospital.setEmail(hospital.getEmail());
        existingHospital.setImageUrl(hospital.getImageUrl());

        return hospitalRepository.save(existingHospital);
    }

    @Override
    public void deleteHospital(Long id) {

        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hospital not found with id: " + id));

        hospitalRepository.delete(hospital);
    }

    @Override
    public Hospital getHospitalById(Long id) {

        return hospitalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hospital not found with id: " + id));
    }

    @Override
    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    @Override
    public List<Hospital> getHospitalsByCity(String city) {
        return hospitalRepository.findByCity(city);
    }

    @Override
    public List<Hospital> searchHospitalByName(String hospitalName) {
        return hospitalRepository.findByHospitalNameContainingIgnoreCase(hospitalName);
    }
}