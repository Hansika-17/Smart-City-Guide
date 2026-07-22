package com.smartcity.smartcityguide.service;

import java.util.List;

import com.smartcity.smartcityguide.entity.Event;

public interface EventService {

    List<Event> getAllEvents();

    Event getEventById(Long id);

    List<Event> getEventsByCity(String city);

    List<Event> getEventsByCategory(String category);

}