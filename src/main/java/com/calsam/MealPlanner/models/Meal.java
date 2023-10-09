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
  @Column
  private List<String> ingredients;
  @Column
  private List<String> measures;

  public Meal(String name, String cuisine, String category, String instructions, String img, List<String> ingredients, List<String> measures){
    this.name = name;
    this.cuisine = cuisine;
    this.category = category;
    this.instructions = instructions;
    this.img = img;
    this.ingredients = ingredients;
    this.measures = measures;
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

  public List<String> getIngredients() {
    return ingredients;
  }

  public List<String> getMeasures() {
    return measures;
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

  public void setIngredients(List<String> ingredients) {
    this.ingredients = ingredients;
  }

  public void setMeasures(List<String> measures) {
    this.measures = measures;
  }

  @Override
  public String toString() {
    return "Meal{" +
            ", ingredients='" + ingredients + '\'' +
            ", measures='" + measures + '\'' +
            '}';
  }

}