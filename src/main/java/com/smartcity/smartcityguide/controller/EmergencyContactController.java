package com.smartcity.smartcityguide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartcity.smartcityguide.entity.EmergencyContact;
import com.smartcity.smartcityguide.service.EmergencyContactService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/emergencycontacts")
@CrossOrigin(origins = "*")
public class EmergencyContactController {

    @Autowired
    private EmergencyContactService emergencyContactService;

    @PostMapping
    public ResponseEntity<EmergencyContact> addEmergencyContact(
            @Valid @RequestBody EmergencyContact emergencyContact) {

        return new ResponseEntity<>(
                emergencyContactService.addEmergencyContact(emergencyContact),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmergencyContact>> getAllEmergencyContacts() {

        return ResponseEntity.ok(
                emergencyContactService.getAllEmergencyContacts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmergencyContact> getEmergencyContactById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                emergencyContactService.getEmergencyContactById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmergencyContact> updateEmergencyContact(
            @PathVariable Long id,
            @Valid @RequestBody EmergencyContact emergencyContact) {

        return ResponseEntity.ok(
                emergencyContactService.updateEmergencyContact(id, emergencyContact));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmergencyContact(
            @PathVariable Long id) {

        emergencyContactService.deleteEmergencyContact(id);

        return ResponseEntity.ok("Emergency Contact deleted successfully");
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<EmergencyContact>> getEmergencyContactsByCity(
            @PathVariable String city) {

        return ResponseEntity.ok(
                emergencyContactService.getEmergencyContactsByCity(city));
    }

    @GetMapping("/search")
    public ResponseEntity<List<EmergencyContact>> searchEmergencyContacts(
            @RequestParam String service) {

        return ResponseEntity.ok(
                emergencyContactService.searchEmergencyContactByService(service));
    }
}