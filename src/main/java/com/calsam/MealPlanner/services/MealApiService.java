package com.calsam.MealPlanner.services;

import java.util.ArrayList;
import java.util.List;

import com.calsam.MealPlanner.models.Meal;
import com.calsam.MealPlanner.models.MealResponse;

import com.calsam.MealPlanner.repositories.MealRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class MealApiService {

    @Autowired
    MealRepository mealRepository;

    public String getMealsByLetter() throws Exception {
        for (int i = 0; i < 26; i++) {
            // lowercase a = 97
            char letter = (char) (i + 97);
            String uri = String.format("https://www.themealdb.com/api/json/v1/1/search.php?f=%c", letter);
            Gson gson = new Gson();

//        Used to send and retrieve HTTP requests
            HttpClient httpClient = HttpClient.newHttpClient();

//        Builds the HTTP request
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI(uri))
                    .build();
//        Sends and receives the response as a String, must state how you handle the response when receiving the data back
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            MealResponse mealResponse = gson.fromJson(getResponse.body(), MealResponse.class);
            System.out.println("The body output is:");
            // System.out.println(getResponse.body());
            System.out.println(mealResponse.getMeals().toString());
            List<MealResponse.Meal> meals = mealResponse.getMeals();
            constructMealObjectFromResponse(meals);
        }
        return "Complete";
    }


    // For loop through meal list to our model
    public void constructMealObjectFromResponse(List<MealResponse.Meal> meals) {
        List<Meal> mealListToSave = new ArrayList<>();
        for (MealResponse.Meal mealToReformat : meals){
            ArrayList<String> ingredients = new ArrayList<>();
            ArrayList<String> measures = new ArrayList<>();
            for (int i = 1; i < 21; i++) {
                try {
                    Field ingredientField = MealResponse.Meal.class.getDeclaredField("strIngredient" + i);
                    Field measureField = MealResponse.Meal.class.getDeclaredField("strMeasure" + i);
                    measureField.setAccessible(true);
                    ingredientField.setAccessible(true);
                    String measure = (String) measureField.get(mealToReformat);
                    String ingredient = (String) ingredientField.get(mealToReformat);
                    if (ingredient != null && !ingredient.isEmpty() && !ingredient.equals(",")) {
                        ingredients.add(ingredient);
                    }
                    if (measure != null && !measure.isEmpty() && !measure.equals(",")) {
                        measures.add(measure);
                    }

                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            Meal meal = new Meal(mealToReformat.getStrMeal(), mealToReformat.getStrArea(), mealToReformat.getStrCategory(), mealToReformat.getStrInstructions(), mealToReformat.getStrMealThumb(), ingredients, measures);
            mealListToSave.add(meal);
        }
        System.out.println(mealListToSave);
        saveIterator(mealListToSave);

    }

    public void saveIterator(List<Meal> meals){
        mealRepository.saveAll(meals);
    }
}
