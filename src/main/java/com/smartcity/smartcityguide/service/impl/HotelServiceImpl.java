package com.smartcity.smartcityguide.service.impl;

import com.smartcity.smartcityguide.entity.Hotel;
import com.smartcity.smartcityguide.exception.ResourceNotFoundException;
import com.smartcity.smartcityguide.repository.HotelRepository;
import com.smartcity.smartcityguide.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotel(Long id, Hotel hotel) {

        Hotel existingHotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + id));

        existingHotel.setHotelName(hotel.getHotelName());
        existingHotel.setCity(hotel.getCity());
        existingHotel.setAddress(hotel.getAddress());
        existingHotel.setDescription(hotel.getDescription());
        existingHotel.setContactNumber(hotel.getContactNumber());
        existingHotel.setEmail(hotel.getEmail());
        existingHotel.setImageUrl(hotel.getImageUrl());
        existingHotel.setRating(hotel.getRating());
        existingHotel.setCategory(hotel.getCategory());
       existingHotel.setPriceRange(hotel.getPriceRange());
existingHotel.setBestFor(hotel.getBestFor());
existingHotel.setAmenities(hotel.getAmenities());

        return hotelRepository.save(existingHotel);
    }

    @Override
    public void deleteHotel(Long id) {

        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + id));

        hotelRepository.delete(hotel);
    }

    @Override
    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + id));
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public List<Hotel> getHotelsByCity(String city) {
        System.out.println("Searching city: " + city);
        List<Hotel> hotels = hotelRepository.findByCity(city);
        System.out.println("Result: " + hotels);
        return hotels;
    }

    @Override
    public List<Hotel> getHotelsByCategory(String category) {
        return hotelRepository.findByCategory(category);
    }

    @Override
    public List<Hotel> searchHotelByName(String hotelName) {
        return hotelRepository.findByHotelNameContainingIgnoreCase(hotelName);
    }

    @Override
    public List<Hotel> getHotelsByRating(Double rating) {
        return hotelRepository.findByRatingGreaterThanEqual(rating);
    }

    @Override
public List<Hotel> getHotelsByCityAndPriceRange(String city, String priceRange) {
    return hotelRepository.findByCityAndPriceRange(city, priceRange);
}

@Override
public List<Hotel> getHotelsByPriceRange(String priceRange) {
    return hotelRepository.findByPriceRange(priceRange);
}
}