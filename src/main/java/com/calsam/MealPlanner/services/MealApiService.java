package com.calsam.MealPlanner.services;
import java.util.List;
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
        MealResponse object = gson.fromJson(getResponse.body(), MealResponse.class);
        System.out.println("The body output is:");
        // System.out.println(getResponse.body());
        System.out.println(object.getMeals().toString());
        return object.getMeals();
    }
}
