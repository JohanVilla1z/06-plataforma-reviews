package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Dish {
  private String name;
  private float price;
  private List<Review> reviews;

  public Dish(String name, float price) {
    this.name = name;
    this.price = price;
    this.reviews = new ArrayList<>();
  }

  public float averageRating() {
    float total = 0;
    for (Review review : reviews) {
      total += review.getRating();
    }
    return reviews.isEmpty() ? 0 : total / reviews.size();
  }

  public void addDishReview(Review review) {
    if (review instanceof DishReview) {
      reviews.add(review);
    }
  }

  public String getName() {
    return name;
  }

  public float getPrice() {
    return price;
  }
}