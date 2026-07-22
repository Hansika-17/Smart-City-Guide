package com.smartcity.smartcityguide.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartcity.smartcityguide.entity.EmergencyContact;
import com.smartcity.smartcityguide.exception.ResourceNotFoundException;
import com.smartcity.smartcityguide.repository.EmergencyContactRepository;
import com.smartcity.smartcityguide.service.EmergencyContactService;

@Service
public class EmergencyContactServiceImpl implements EmergencyContactService {

    @Autowired
    private EmergencyContactRepository emergencyContactRepository;

    @Override
    public EmergencyContact addEmergencyContact(EmergencyContact emergencyContact) {
        return emergencyContactRepository.save(emergencyContact);
    }

    @Override
    public EmergencyContact updateEmergencyContact(Long id, EmergencyContact emergencyContact) {

        EmergencyContact existing = emergencyContactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Emergency Contact not found with id: " + id));

        existing.setServiceName(emergencyContact.getServiceName());
        existing.setCity(emergencyContact.getCity());
        existing.setPhoneNumber(emergencyContact.getPhoneNumber());
        existing.setDescription(emergencyContact.getDescription());

        return emergencyContactRepository.save(existing);
    }

    @Override
    public void deleteEmergencyContact(Long id) {

        EmergencyContact emergencyContact = emergencyContactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Emergency Contact not found with id: " + id));

        emergencyContactRepository.delete(emergencyContact);
    }

    @Override
    public EmergencyContact getEmergencyContactById(Long id) {

        return emergencyContactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Emergency Contact not found with id: " + id));
    }

    @Override
    public List<EmergencyContact> getAllEmergencyContacts() {
        return emergencyContactRepository.findAll();
    }

    @Override
    public List<EmergencyContact> getEmergencyContactsByCity(String city) {
        return emergencyContactRepository.findByCity(city);
    }

    @Override
    public List<EmergencyContact> searchEmergencyContactByService(String serviceName) {
        return emergencyContactRepository.findByServiceNameContainingIgnoreCase(serviceName);
    }
}