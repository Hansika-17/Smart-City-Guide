package com.smartcity.smartcityguide.service;

import java.util.List;

import com.smartcity.smartcityguide.entity.EmergencyContact;

public interface EmergencyContactService {

    EmergencyContact addEmergencyContact(EmergencyContact emergencyContact);

    EmergencyContact updateEmergencyContact(Long id, EmergencyContact emergencyContact);

    void deleteEmergencyContact(Long id);

    EmergencyContact getEmergencyContactById(Long id);

    List<EmergencyContact> getAllEmergencyContacts();

    List<EmergencyContact> getEmergencyContactsByCity(String city);

    List<EmergencyContact> searchEmergencyContactByService(String serviceName);
}