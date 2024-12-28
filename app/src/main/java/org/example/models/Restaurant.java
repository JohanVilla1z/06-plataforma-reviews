package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
  private String name;
  private String city;
  private Menu menu;
  private List<Review> reviews;
  private float averageRating;

  public Restaurant(String name, String city, Menu menu) {
    this.name = name;
    this.city = city;
    this.menu = menu;
    this.reviews = new ArrayList<>();
    this.averageRating = 0.0f;
  }

  public Restaurant() {
  }

  public void calculateAverageRating() {
    float total = 0;
    for (Review review : reviews) {
      total += review.getRating();
    }
    this.averageRating = reviews.isEmpty() ? 0 : total / reviews.size();
  }

  public void addRestaurantReview(Review review) {
    if (review instanceof RestaurantReview) {
      reviews.add(review);
      calculateAverageRating();
    }
  }

  // Getters y Setters
  public String getName() {
    return name;
  }

  public String getCity() {
    return city;
  }

  public Menu getMenu() {
    return menu;
  }

  public float getAverageRating() {
    return averageRating;
  }
}