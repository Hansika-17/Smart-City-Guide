package com.smartcity.smartcityguide.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartcity.smartcityguide.entity.Hotel;
import com.smartcity.smartcityguide.exception.ResourceNotFoundException;
import com.smartcity.smartcityguide.repository.HotelRepository;
import com.smartcity.smartcityguide.service.HotelService;

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
        return hotelRepository.findByCity(city);
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
}