package com.calsam.MealPlanner.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MealApiService {

    public String getMealsByLetter(Character letter) {
        String uri = String.format("https://www.themealdb.com/api/json/v1/1/search.php?f=%c", letter);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
//        return result;
        System.out.println(result);
        return result;
    }
}
