package com.smartcity.smartcityguide.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hotels")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Hotel name is required")
    @Column(nullable = false, length = 100)
    private String hotelName;

    @NotBlank(message = "City is required")
    @Column(nullable = false, length = 50)
    private String city;

    @NotBlank(message = "Address is required")
    @Column(nullable = false, length = 255)
    private String address;

    @Column(length = 1000)
    private String description;

    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact number must contain exactly 10 digits")
    @Column(nullable = false, length = 10)
    private String contactNumber;

    @Email(message = "Invalid email format")
    @Column(length = 100)
    private String email;

    @Column(length = 500)
    private String imageUrl;

    @Min(value = 0, message = "Rating cannot be less than 0")
    @Max(value = 5, message = "Rating cannot be greater than 5")
    @Column(nullable = false)
    private Double rating;

    @NotBlank(message = "Category is required")
    @Column(nullable = false, length = 30)
    private String category;
}