package com.calsam.MealPlanner.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.calsam.MealPlanner.models.User;
import com.calsam.MealPlanner.models.UserDto;
import com.calsam.MealPlanner.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public User createUser(UserDto userDto) {

        String encodePassword = passwordEncoder
                .encode(userDto.getPassword());

        User newUser = new User(userDto.getUsername(), encodePassword, userDto.getEmail());

        return userRepository.save(newUser);
    }
}