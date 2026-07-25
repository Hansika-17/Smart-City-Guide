package com.smartcity.smartcityguide.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartcity.smartcityguide.entity.Event;
import com.smartcity.smartcityguide.repository.EventRepository;
import com.smartcity.smartcityguide.service.EventService;


@Service
public class EventServiceImpl implements EventService {


    private final EventRepository eventRepository;


    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    @Override
    public List<Event> getAllEvents() {

        return eventRepository.findAll();
    }


    @Override
    public Event getEventById(Long id) {

        return eventRepository.findById(id)
                .orElse(null);
    }


    @Override
    public List<Event> getEventsByCity(String city) {

        return eventRepository.findByCity(city);
    }

    @Override
public List<Event> getEventsByCategory(String category) {

    return eventRepository.findByCategory(category);

}

    @Override
public List<Event> getEventsByCityAndCategory(String city, String category) {
    return eventRepository.findByCityAndCategory(city, category);
}

}