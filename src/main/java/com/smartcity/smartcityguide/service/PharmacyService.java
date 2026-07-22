package com.smartcity.smartcityguide.service;

import java.util.List;

import com.smartcity.smartcityguide.entity.Pharmacy;

public interface PharmacyService {

    Pharmacy addPharmacy(Pharmacy pharmacy);

    Pharmacy updatePharmacy(Long id, Pharmacy pharmacy);

    void deletePharmacy(Long id);

    Pharmacy getPharmacyById(Long id);

    List<Pharmacy> getAllPharmacies();

    List<Pharmacy> getPharmaciesByCity(String city);

    List<Pharmacy> searchPharmacyByName(String pharmacyName);

}