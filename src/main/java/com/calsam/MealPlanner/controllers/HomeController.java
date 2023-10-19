package com.calsam.MealPlanner.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
  
  @GetMapping
  public String home(Principal principal) {
    return "Hello, World";
  }
}
