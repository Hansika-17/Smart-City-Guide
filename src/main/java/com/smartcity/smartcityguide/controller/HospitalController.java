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

import com.smartcity.smartcityguide.entity.Hospital;
import com.smartcity.smartcityguide.service.HospitalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/hospitals")
@CrossOrigin(origins = "*")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @PostMapping
    public ResponseEntity<Hospital> addHospital(@Valid @RequestBody Hospital hospital) {

        return new ResponseEntity<>(hospitalService.addHospital(hospital), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Hospital>> getAllHospitals() {

        return ResponseEntity.ok(hospitalService.getAllHospitals());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospital> getHospitalById(@PathVariable Long id) {

        return ResponseEntity.ok(hospitalService.getHospitalById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hospital> updateHospital(@PathVariable Long id,
                                                   @Valid @RequestBody Hospital hospital) {

        return ResponseEntity.ok(hospitalService.updateHospital(id, hospital));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHospital(@PathVariable Long id) {

        hospitalService.deleteHospital(id);

        return ResponseEntity.ok("Hospital deleted successfully");
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<Hospital>> getHospitalsByCity(@PathVariable String city) {

        return ResponseEntity.ok(hospitalService.getHospitalsByCity(city));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Hospital>> searchHospital(@RequestParam String name) {

        return ResponseEntity.ok(hospitalService.searchHospitalByName(name));
    }
}