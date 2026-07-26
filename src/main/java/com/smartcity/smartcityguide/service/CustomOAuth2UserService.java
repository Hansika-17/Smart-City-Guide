package com.smartcity.smartcityguide.service;

import com.smartcity.smartcityguide.entity.User;
import com.smartcity.smartcityguide.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest)
            throws OAuth2AuthenticationException {

                System.out.println("===== CustomOAuth2UserService called =====");

                OAuth2User oAuth2User = super.loadUser(userRequest);

                String email = oAuth2User.getAttribute("email");
                String name = oAuth2User.getAttribute("name");

                User user = userRepository.findByEmail(email).orElse(null);

                if (user == null) {

                        user = new User();

                        user.setName(name);
                        user.setEmail(email);

                        user.setRole("USER");

                        user.setVerified(true);
                        user.setOtpVerified(true);

                        user.setPassword("GOOGLE_LOGIN");
                        
                        userRepository.save(user);
                    }

        return oAuth2User;

    }
}
