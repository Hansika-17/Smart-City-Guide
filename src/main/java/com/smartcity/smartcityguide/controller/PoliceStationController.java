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

import com.smartcity.smartcityguide.entity.PoliceStation;
import com.smartcity.smartcityguide.service.PoliceStationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/policestations")
@CrossOrigin(origins = "*")
public class PoliceStationController {

    @Autowired
    private PoliceStationService policeStationService;

    @PostMapping
    public ResponseEntity<PoliceStation> addPoliceStation(@Valid @RequestBody PoliceStation policeStation) {

        return new ResponseEntity<>(policeStationService.addPoliceStation(policeStation), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PoliceStation>> getAllPoliceStations() {

        return ResponseEntity.ok(policeStationService.getAllPoliceStations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PoliceStation> getPoliceStationById(@PathVariable Long id) {

        return ResponseEntity.ok(policeStationService.getPoliceStationById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PoliceStation> updatePoliceStation(@PathVariable Long id, @Valid @RequestBody PoliceStation policeStation) {

        return ResponseEntity.ok(policeStationService.updatePoliceStation(id, policeStation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePoliceStation(@PathVariable Long id) {

        policeStationService.deletePoliceStation(id);

        return ResponseEntity.ok("Police Station deleted successfully");
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<PoliceStation>> getPoliceStationsByCity(@PathVariable String city) {

        return ResponseEntity.ok(policeStationService.getPoliceStationsByCity(city));
    }

    @GetMapping("/search")
    public ResponseEntity<List<PoliceStation>> searchPoliceStations(@RequestParam String name) {

        return ResponseEntity.ok(policeStationService.searchPoliceStationByName(name));
    }
}