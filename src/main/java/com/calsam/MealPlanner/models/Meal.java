package com.calsam.MealPlanner.models;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table (name = "meals")
public class Meal {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String name;
  @Column
  private String cuisine;
  @Column
  private String category;
  @Column
  private String instructions;
  @Column
  private String img;

  public Meal(String name, String cuisine, String category, String instructions, String img){
    this.name = name;
    this.cuisine = cuisine;
    this.category = category;
    this.instructions = instructions;
    this.img = img;
  }

  public Meal(){

  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getCuisine() {
    return cuisine;
  }

  public String getCategory() {
    return category;
  }

  public String getInstructions() {
    return instructions;
  }

  public String getImg() {
    return img;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCuisine(String cuisine) {
    this.cuisine = cuisine;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public void setInstructions(String instructions) {
    this.instructions = instructions;
  }

  public void setImg(String img) {
    this.img = img;
  }

}
