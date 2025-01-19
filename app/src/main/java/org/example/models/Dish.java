package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Dish {
  private Integer dishId;
  private String name;
  private String description;
  private Float price;
  private List<Review> reviews;

  private static Integer idCounter = 0;

  public Dish(String name, String description, Float price) {
    this.dishId = generateId();
    this.name = name;
    this.price = price;
    this.description = description;
    this.price = price;
    this.reviews = new ArrayList<>();
  }

  private Integer generateId() {
    return idCounter++;
  }

  public Float averageRating() {
    Float total = 0f;
    for (Review review : reviews) {
      total += review.getAverageRating();
    }
    return reviews.isEmpty() ? 0 : total / reviews.size();
  }

  public void addDishReview(Review review) {
    if (review instanceof DishReview) {
      reviews.add(review);
    }
  }

  public Integer getDishId() {
    return dishId;
  }

  public void setDishId(Integer dishId) {
    this.dishId = dishId;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public String getName() {
    return name;
  }

  public Float getPrice() {
    return price;
  }
}