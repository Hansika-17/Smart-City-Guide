package com.smartcity.smartcityguide.service;

import com.smartcity.smartcityguide.entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel addHotel(Hotel hotel);

    Hotel updateHotel(Long id, Hotel hotel);

    void deleteHotel(Long id);

    Hotel getHotelById(Long id);

    List<Hotel> getAllHotels();

    List<Hotel> getHotelsByCity(String city);

    List<Hotel> getHotelsByCategory(String category);

    List<Hotel> searchHotelByName(String hotelName);

    List<Hotel> getHotelsByRating(Double rating);

    List<Hotel> getHotelsByCityAndPriceRange(String city, String priceRange);

    List<Hotel> getHotelsByPriceRange(String priceRange);

    List<Hotel> getHotelsByBestFor(String bestFor);

    List<Hotel> getHotelsByCityAndBestFor(String city, String bestFor);

    List<Hotel> getHotelsByCityAndPriceRangeAndBestFor(
        String city,
        String priceRange,
        String bestFor
);
}