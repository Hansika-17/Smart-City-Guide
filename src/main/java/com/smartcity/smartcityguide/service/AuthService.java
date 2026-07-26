package com.smartcity.smartcityguide.service;

import com.smartcity.smartcityguide.entity.User;
import com.smartcity.smartcityguide.repository.UserRepository;
import com.smartcity.smartcityguide.util.OtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Register Method
    public String register(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            return "Email already exists!";
        }

        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Generate OTP
        String otp = OtpUtil.generateOtp();

        // Save OTP
        user.setOtp(otp);
        user.setOtpVerified(false);

        userRepository.save(user);

        // Print OTP in console (temporary)
        System.out.println("OTP for " + user.getEmail() + " : " + otp);

        return "User Registered Successfully. OTP Generated.";
    }

    // Login Method
    public String login(String email, String password) {

        User user = userRepository.findByEmail(email).orElse(null);

        if (user == null) {
            return "User not found";
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            return "Invalid Password";
        }

        // Check if user has verified OTP
        if (!user.isVerified()) {
            return "Please verify your email first";
        }

        return "Login Successful";
    }

    // Verify OTP Method
    public String verifyOtp(String email, String otp) {

        User user = userRepository.findByEmail(email).orElse(null);

        if (user == null) {
            return "User not found";
        }

        if (user.getOtp() == null) {
            return "OTP not generated";
        }

        if (!user.getOtp().equals(otp)) {
            return "Invalid OTP";
        }

        user.setOtpVerified(true);
        user.setVerified(true);
        user.setOtp(null);

        userRepository.save(user);

        return "OTP Verified Successfully";
    }

    // Forgot Password Method
    public String forgotPassword(String email) {

        User user = userRepository.findByEmail(email).orElse(null);

        if (user == null) {
            return "User not found";
        }

        // Generate new OTP
        String otp = OtpUtil.generateOtp();

        user.setOtp(otp);
        user.setOtpVerified(false);

        userRepository.save(user);

        // Print OTP in console (temporary)
        System.out.println("Password Reset OTP for " + email + " : " + otp);

        return "Password Reset OTP Generated";
    }

    // Reset Password Method
    public String resetPassword(String email, String otp, String newPassword) {

        User user = userRepository.findByEmail(email).orElse(null);

        if (user == null) {
            return "User not found";
        }

        if (user.getOtp() == null) {
            return "OTP not generated";
        }

        if (!user.getOtp().equals(otp)) {
            return "Invalid OTP";
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        user.setOtp(null);
        user.setOtpVerified(true);
        user.setVerified(true);

        userRepository.save(user);

        return "Password Reset Successfully";
    }
}