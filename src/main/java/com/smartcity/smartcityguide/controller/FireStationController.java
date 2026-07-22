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

import com.smartcity.smartcityguide.entity.FireStation;
import com.smartcity.smartcityguide.service.FireStationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/firestations")
@CrossOrigin(origins = "*")
public class FireStationController {

    @Autowired
    private FireStationService fireStationService;

    @PostMapping
    public ResponseEntity<FireStation> addFireStation(@Valid @RequestBody FireStation fireStation) {

        return new ResponseEntity<>(fireStationService.addFireStation(fireStation), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FireStation>> getAllFireStations() {

        return ResponseEntity.ok(fireStationService.getAllFireStations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FireStation> getFireStationById(@PathVariable Long id) {

        return ResponseEntity.ok(fireStationService.getFireStationById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FireStation> updateFireStation(@PathVariable Long id,
                                                         @Valid @RequestBody FireStation fireStation) {

        return ResponseEntity.ok(fireStationService.updateFireStation(id, fireStation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFireStation(@PathVariable Long id) {

        fireStationService.deleteFireStation(id);

        return ResponseEntity.ok("Fire Station deleted successfully");
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<FireStation>> getFireStationsByCity(@PathVariable String city) {

        return ResponseEntity.ok(fireStationService.getFireStationsByCity(city));
    }

    @GetMapping("/search")
    public ResponseEntity<List<FireStation>> searchFireStations(@RequestParam String name) {

        return ResponseEntity.ok(fireStationService.searchFireStationByName(name));
    }
}