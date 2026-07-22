package com.smartcity.smartcityguide.controller;

import com.smartcity.smartcityguide.entity.TouristPlace;
import com.smartcity.smartcityguide.service.TouristPlaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/touristplaces")
@CrossOrigin(origins = "*")
public class TouristPlaceController {

    @Autowired
    private TouristPlaceService service;

    @PostMapping
    public ResponseEntity<TouristPlace> add(@Valid @RequestBody TouristPlace touristPlace) {
        return new ResponseEntity<>(service.addTouristPlace(touristPlace), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TouristPlace>> getAll() {
        return ResponseEntity.ok(service.getAllTouristPlaces());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TouristPlace> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getTouristPlaceById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TouristPlace> update(@PathVariable Long id,
                                               @Valid @RequestBody TouristPlace touristPlace) {
        return ResponseEntity.ok(service.updateTouristPlace(id, touristPlace));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteTouristPlace(id);
        return ResponseEntity.ok("Tourist Place deleted successfully");
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<TouristPlace>> getByCity(@PathVariable String city) {
        return ResponseEntity.ok(service.getTouristPlacesByCity(city));
    }

    @GetMapping("/search")
    public ResponseEntity<List<TouristPlace>> search(@RequestParam String name) {
        return ResponseEntity.ok(service.searchTouristPlaceByName(name));
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<TouristPlace>> getByRating(@PathVariable Double rating) {
        return ResponseEntity.ok(service.getTouristPlacesByRating(rating));
    }
}