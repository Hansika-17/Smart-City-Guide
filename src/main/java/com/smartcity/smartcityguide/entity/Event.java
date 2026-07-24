package com.smartcity.smartcityguide.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "events")
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "event_name", nullable = false)
    private String eventName;


    @Column(nullable = false)
    private String city;


    @Column(nullable = false)
    private String category;


    @Column(nullable = false)
    private String venue;


    @Column(name = "ticket_price")
    private String ticketPrice;


    private String timings;


    @Column(length = 1000)
    private String description;


    @Column(name = "image_url")
    private String imageUrl;


    @Column(name = "best_for")
    private String bestFor;

}