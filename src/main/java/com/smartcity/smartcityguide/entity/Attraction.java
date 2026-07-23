package com.smartcity.smartcityguide.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "attractions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "attraction_name", nullable = false)
    private String attractionName;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Double rating;

    @Column(name = "entry_fee")
    private String entryFee;

    @Column(name = "time_required")
    private String timeRequired;

    @Column(length = 1000)
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "map_link")
    private String mapLink;

    @Column(name = "best_for")
    private String bestFor;
}