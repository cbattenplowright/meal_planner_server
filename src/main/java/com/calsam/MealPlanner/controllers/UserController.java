package com.calsam.MealPlanner.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.calsam.MealPlanner.models.User;
import com.calsam.MealPlanner.models.UserDto;

@RestController
public class UserController {
  
  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody UserDto userDto){
    return userService.createUser(userDto);
  }
}
