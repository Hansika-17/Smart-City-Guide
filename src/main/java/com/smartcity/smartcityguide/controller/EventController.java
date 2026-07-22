package com.smartcity.smartcityguide.controller;


import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.smartcity.smartcityguide.entity.Event;
import com.smartcity.smartcityguide.service.EventService;



@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "*")
public class EventController {


    private final EventService eventService;


    public EventController(EventService eventService) {

        this.eventService = eventService;
    }



    // Get all events

    @GetMapping
    public List<Event> getAllEvents(){

        return eventService.getAllEvents();
    }



    // Get event by id

    @GetMapping("/{id}")
    public Event getEventById(
            @PathVariable Long id){

        return eventService.getEventById(id);
    }



    // Get events based on city

    @GetMapping("/city/{city}")
    public List<Event> getEventsByCity(
            @PathVariable String city){

        return eventService.getEventsByCity(city);
    }

    @GetMapping("/category/{category}")
public List<Event> getEventsByCategory(
        @PathVariable String category){

    return eventService.getEventsByCategory(category);
}

}