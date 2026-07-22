package com.smartcity.smartcityguide.controller;

import com.smartcity.smartcityguide.entity.Hotel;
import com.smartcity.smartcityguide.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
@CrossOrigin(origins = "*")
public class HotelController {

    @Autowired
    private HotelService hotelService;


    // Add Hotel
    @PostMapping
    public ResponseEntity<Hotel> addHotel(@Valid @RequestBody Hotel hotel) {

        return new ResponseEntity<>(
                hotelService.addHotel(hotel),
                HttpStatus.CREATED
        );
    }


    // Get All Hotels
    @GetMapping
public ResponseEntity<List<Hotel>> getHotels(
        @RequestParam(required = false) String city,
        @RequestParam(required = false) String priceRange) {

    if (city != null && priceRange != null) {
        return ResponseEntity.ok(
                hotelService.getHotelsByCityAndPriceRange(city, priceRange)
        );
    }

    if (city != null) {
        return ResponseEntity.ok(
                hotelService.getHotelsByCity(city)
        );
    }

    if (priceRange != null) {
        return ResponseEntity.ok(
                hotelService.getHotelsByPriceRange(priceRange)
        );
    }

    return ResponseEntity.ok(
            hotelService.getAllHotels()
    );
}


    // Get Hotel By ID
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                hotelService.getHotelById(id)
        );
    }


    // Update Hotel
    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(
            @PathVariable Long id,
            @Valid @RequestBody Hotel hotel) {

        return ResponseEntity.ok(
                hotelService.updateHotel(id, hotel)
        );
    }


    // Delete Hotel
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHotel(
            @PathVariable Long id) {

        hotelService.deleteHotel(id);

        return ResponseEntity.ok(
                "Hotel deleted successfully"
        );
    }


    // Search by City
    @GetMapping("/city/{city}")
    public ResponseEntity<List<Hotel>> getHotelsByCity(
            @PathVariable String city) {

        return ResponseEntity.ok(
                hotelService.getHotelsByCity(city)
        );
    }


    // Search by Category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Hotel>> getHotelsByCategory(
            @PathVariable String category) {

        return ResponseEntity.ok(
                hotelService.getHotelsByCategory(category)
        );
    }


    // Search by Name
    @GetMapping("/search")
    public ResponseEntity<List<Hotel>> searchHotels(
            @RequestParam String name) {

        return ResponseEntity.ok(
                hotelService.searchHotelByName(name)
        );
    }


    // Filter by Rating
    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<Hotel>> getHotelsByRating(
            @PathVariable Double rating) {

        return ResponseEntity.ok(
                hotelService.getHotelsByRating(rating)
        );
    }
}