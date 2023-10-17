package com.calsam.MealPlanner.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.calsam.MealPlanner.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
  User findByUsername(String username);
}
