package com.smartcity.smartcityguide.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hospitals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Hospital name is required")
    @Column(nullable = false, length = 100)
    private String hospitalName;

    @NotBlank(message = "City is required")
    @Column(nullable = false, length = 50)
    private String city;

    @NotBlank(message = "Address is required")
    @Column(nullable = false)
    private String address;

    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact number must contain exactly 10 digits")
    @Column(nullable = false)
    private String contactNumber;

    @Email
    private String email;

    @Column(length = 500)
    private String imageUrl;
}