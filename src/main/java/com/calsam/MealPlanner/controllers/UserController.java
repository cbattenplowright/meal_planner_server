package com.calsam.MealPlanner.controllers;

import com.calsam.MealPlanner.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.calsam.MealPlanner.models.User;
import com.calsam.MealPlanner.models.UserDto;

@RestController
@RequestMapping({"/user"})
public class UserController {

  @Autowired
  UserService userService;

//  @PostMapping("/createUser")
//  public ResponseEntity<User> createUser(@RequestBody UserDto userDto){
//    return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
//  }
}
