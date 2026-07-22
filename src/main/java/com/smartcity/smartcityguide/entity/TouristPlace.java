package com.smartcity.smartcityguide.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tourist_places")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TouristPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Place name is required")
    @Column(nullable = false, length = 100)
    private String placeName;

    @NotBlank(message = "City is required")
    @Column(nullable = false, length = 50)
    private String city;

    @Column(length = 1000)
    private String description;

    @NotBlank(message = "Image URL is required")
    @Column(length = 500)
    private String imageUrl;

    @NotBlank(message = "Timings are required")
    @Column(length = 100)
    private String timings;

    @Min(value = 0, message = "Rating cannot be less than 0")
    @Max(value = 5, message = "Rating cannot be greater than 5")
    @Column(nullable = false)
    private Double rating;
}