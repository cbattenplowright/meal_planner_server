package com.calsam.MealPlanner.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.calsam.MealPlanner.models.User;
import com.calsam.MealPlanner.models.UserDto;
import com.calsam.MealPlanner.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public User createUser(UserDto userDto) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String encodePassword = bCryptPasswordEncoder
                .encode(userDto.getPassword());

        User newUser = new User(userDto.getUsername(), encodePassword, userDto.getEmail());
        return userRepository.save(newUser);
    }
}