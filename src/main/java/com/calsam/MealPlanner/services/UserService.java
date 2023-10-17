package com.calsam.MealPlanner.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calsam.MealPlanner.models.User;
import com.calsam.MealPlanner.models.UserDto;
import com.calsam.MealPlanner.repositories.UserRepository;

@Service
public class UserService{
  @Autowired
  UserRepository userRepository;

  public User createUser(UserDto userDto){
    
  }
}