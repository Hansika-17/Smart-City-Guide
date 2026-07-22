package com.smartcity.smartcityguide.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartcity.smartcityguide.entity.Pharmacy;
import com.smartcity.smartcityguide.exception.ResourceNotFoundException;
import com.smartcity.smartcityguide.repository.PharmacyRepository;
import com.smartcity.smartcityguide.service.PharmacyService;

@Service
public class PharmacyServiceImpl implements PharmacyService {

    @Autowired
    private PharmacyRepository pharmacyRepository;

    @Override
    public Pharmacy addPharmacy(Pharmacy pharmacy) {
        return pharmacyRepository.save(pharmacy);
    }

    @Override
    public Pharmacy updatePharmacy(Long id, Pharmacy pharmacy) {

        Pharmacy existing = pharmacyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pharmacy not found with id: " + id));

        existing.setPharmacyName(pharmacy.getPharmacyName());
        existing.setCity(pharmacy.getCity());
        existing.setAddress(pharmacy.getAddress());
        existing.setContactNumber(pharmacy.getContactNumber());
        existing.setEmail(pharmacy.getEmail());
        existing.setImageUrl(pharmacy.getImageUrl());

        return pharmacyRepository.save(existing);
    }

    @Override
    public void deletePharmacy(Long id) {

        Pharmacy pharmacy = pharmacyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pharmacy not found with id: " + id));

        pharmacyRepository.delete(pharmacy);
    }

    @Override
    public Pharmacy getPharmacyById(Long id) {

        return pharmacyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pharmacy not found with id: " + id));
    }

    @Override
    public List<Pharmacy> getAllPharmacies() {
        return pharmacyRepository.findAll();
    }

    @Override
    public List<Pharmacy> getPharmaciesByCity(String city) {
        return pharmacyRepository.findByCity(city);
    }

    @Override
    public List<Pharmacy> searchPharmacyByName(String pharmacyName) {
        return pharmacyRepository.findByPharmacyNameContainingIgnoreCase(pharmacyName);
    }
}