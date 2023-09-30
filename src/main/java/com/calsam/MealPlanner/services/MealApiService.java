package com.calsam.MealPlanner.services;
import java.util.ArrayList;
import java.util.List;

import com.calsam.MealPlanner.models.Meal;
import com.calsam.MealPlanner.models.MealResponse;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class MealApiService {

    public List<MealResponse.Meal> getMealsByLetter(Character letter) throws Exception{
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
        constructMealObjectsFromResponse(mealResponse.getMeals().get(0));
        return mealResponse.getMeals();
    }


    // For loop through meal list to our model
    public void constructMealObjectsFromResponse(MealResponse.Meal mealObjectFromAPI) {
        ArrayList<String> ingredients = new ArrayList<>();
        ArrayList<String> measures = new ArrayList<>();

        int getterIndex = 1;

        ingredients.add(mealObjectFromAPI.getStrIngredient1());
        measures.add(mealObjectFromAPI.getStrMeasure1());
//        for(int i = 1; i < 21; i++){
//            try {
//                String ingredient = (String) MealResponse.Meal.class.getDeclaredField("strIngredient" + i).get(mealObjectFromAPI);
//                String measure = (String) MealResponse.Meal.class.getDeclaredField("strMeasure" + i).get(mealObjectFromAPI);
//                // Check if the ingredient is not null or empty
//                if (ingredient != null && !ingredient.isEmpty()) {
//                    ingredients.add(ingredient);
//                }
//                if (measure != null && !measure.isEmpty()) {
//                    measures.add(measure);
//                }
//
//            } catch (NoSuchFieldException | IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }

        Meal meal = new Meal(mealObjectFromAPI.getStrMeal(), mealObjectFromAPI.getStrArea(), mealObjectFromAPI.getStrCategory(), mealObjectFromAPI.getStrInstructions(), mealObjectFromAPI.getStrMealThumb(), ingredients, measures);

        System.out.println(meal);
    }
}
