package com.calsam.MealPlanner.repositories;

import com.calsam.MealPlanner.models.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

//    @Query(value = "SELECT * FROM meals LIMIT 1", nativeQuery = true)
//    List<Meal> findAllMeals();
}
