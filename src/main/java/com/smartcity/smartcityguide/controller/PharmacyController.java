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

import com.smartcity.smartcityguide.entity.Pharmacy;
import com.smartcity.smartcityguide.service.PharmacyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pharmacies")
@CrossOrigin(origins = "*")
public class PharmacyController {

    @Autowired
    private PharmacyService pharmacyService;

    @PostMapping
    public ResponseEntity<Pharmacy> addPharmacy(@Valid @RequestBody Pharmacy pharmacy) {

        return new ResponseEntity<>(pharmacyService.addPharmacy(pharmacy), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pharmacy>> getAllPharmacies() {

        return ResponseEntity.ok(pharmacyService.getAllPharmacies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pharmacy> getPharmacyById(@PathVariable Long id) {

        return ResponseEntity.ok(pharmacyService.getPharmacyById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pharmacy> updatePharmacy(@PathVariable Long id, @Valid @RequestBody Pharmacy pharmacy) {

        return ResponseEntity.ok(pharmacyService.updatePharmacy(id, pharmacy));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePharmacy(@PathVariable Long id) {

        pharmacyService.deletePharmacy(id);

        return ResponseEntity.ok("Pharmacy deleted successfully");
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<Pharmacy>> getPharmaciesByCity(@PathVariable String city) {

        return ResponseEntity.ok(pharmacyService.getPharmaciesByCity(city));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Pharmacy>> searchPharmacies(@RequestParam String name) {

        return ResponseEntity.ok(pharmacyService.searchPharmacyByName(name));
    }
}