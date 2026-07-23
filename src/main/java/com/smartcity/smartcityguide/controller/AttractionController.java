package com.smartcity.smartcityguide.controller;

import com.smartcity.smartcityguide.entity.Attraction;
import com.smartcity.smartcityguide.service.AttractionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attractions")
@CrossOrigin(origins = "*")
public class AttractionController {

    @Autowired
    private AttractionService service;

    @PostMapping
    public ResponseEntity<Attraction> add(@Valid @RequestBody Attraction attraction) {
        return new ResponseEntity<>(service.addAttraction(attraction), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Attraction>> getAll() {
        return ResponseEntity.ok(service.getAllAttractions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attraction> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAttractionById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Attraction> update(@PathVariable Long id,
                                             @Valid @RequestBody Attraction attraction) {
        return ResponseEntity.ok(service.updateAttraction(id, attraction));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteAttraction(id);
        return ResponseEntity.ok("Attraction deleted successfully");
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<Attraction>> getByCity(@PathVariable String city) {
        return ResponseEntity.ok(service.getAttractionsByCity(city));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Attraction>> search(@RequestParam String name) {
        return ResponseEntity.ok(service.searchAttractionByName(name));
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<Attraction>> getByRating(@PathVariable Double rating) {
        return ResponseEntity.ok(service.getAttractionsByRating(rating));
    }

    
    @GetMapping(params = "city")
    public ResponseEntity<List<Attraction>> getByCityParam(
           @RequestParam String city) {

         return ResponseEntity.ok(service.getAttractionsByCity(city));
    }
}