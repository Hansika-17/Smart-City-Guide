package com.smartcity.smartcityguide.service;

import com.smartcity.smartcityguide.entity.Hospital;

import java.util.List;

public interface HospitalService {

    Hospital addHospital(Hospital hospital);

    Hospital updateHospital(Long id, Hospital hospital);

    void deleteHospital(Long id);

    Hospital getHospitalById(Long id);

    List<Hospital> getAllHospitals();

    List<Hospital> getHospitalsByCity(String city);

    List<Hospital> searchHospitalByName(String hospitalName);

}