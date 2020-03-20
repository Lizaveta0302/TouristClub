package com.lizoon.touristclub.service;

import com.lizoon.touristclub.entity.User;
import com.lizoon.touristclub.mvc.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
