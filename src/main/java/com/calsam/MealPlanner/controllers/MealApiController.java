package com.calsam.MealPlanner.controllers;
import com.calsam.MealPlanner.models.Meal;
import com.calsam.MealPlanner.models.MealResponse;
import com.calsam.MealPlanner.services.MealApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/meals")
public class MealApiController {

    @Autowired
    MealApiService mealApiService;

    @GetMapping(value = "/fetch")
    public ResponseEntity<String> getMealsByLetter() throws Exception {
        String meals = mealApiService.getMealsByLetter();
        return new ResponseEntity<>(meals, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Meal>> findAllMeals() {
        List<Meal> meals = mealApiService.findAllMeals();
        return new ResponseEntity<>(meals, HttpStatus.OK);
    }
}
