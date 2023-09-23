package com.calsam.MealPlanner.controllers;

import com.calsam.MealPlanner.services.MealApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/meals")
public class MealApiController {

    @Autowired
    MealApiService mealApiService;

    @GetMapping(value = "/{letter}")
    public ResponseEntity<String> getMealsByLetter(@PathVariable("letter") Character letter){
        return new ResponseEntity<String>(mealApiService.getMealsByLetter(letter), HttpStatus.OK);
    }

}
