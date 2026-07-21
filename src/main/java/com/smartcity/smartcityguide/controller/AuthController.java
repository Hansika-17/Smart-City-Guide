package com.smartcity.smartcityguide.controller;

import com.smartcity.smartcityguide.dto.LoginRequest;
import com.smartcity.smartcityguide.dto.OtpRequest;
import com.smartcity.smartcityguide.entity.User;
import com.smartcity.smartcityguide.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Register API
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return authService.register(user);
    }

    // Login API
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return authService.login(request.getEmail(), request.getPassword());
    }

    // Verify OTP API
    @PostMapping("/verify-otp")
    public String verifyOtp(@RequestBody OtpRequest request) {
        return authService.verifyOtp(request.getEmail(), request.getOtp());
    }

    // Forgot Password API
    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestBody OtpRequest request) {
        return authService.forgotPassword(request.getEmail());
    }

    // Reset Password API
    @PostMapping("/reset-password")
    public String resetPassword(
            @RequestParam String email,
            @RequestParam String otp,
            @RequestParam String newPassword) {

        return authService.resetPassword(email, otp, newPassword);
    }
}