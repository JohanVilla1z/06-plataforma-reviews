package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
  private String name;
  private String city;
  private Menu menu;
  private List<Review> reviews;
  private Float averageRating;

  public Restaurant(String name, String city, Menu menu) {
    this.name = name;
    this.city = city;
    this.menu = menu;
    this.reviews = new ArrayList<>();
    this.averageRating = calculateAverageRating();
  }

  public Restaurant(String name, String city) {
    this.name = name;
    this.city = city;
    this.menu = new Menu();
    this.reviews = new ArrayList<>();
    this.averageRating = calculateAverageRating();
  }

  public Restaurant() {
  }

  public Float calculateAverageRating() {
    Float total = 0f;
    for (Review review : reviews) {
      total += review.getRating();
    }
    return reviews.isEmpty() ? 0 : total / reviews.size();
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

  public Float getAverageRating() {
    return averageRating;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }

  public void setAverageRating(Float averageRating) {
    this.averageRating = averageRating;
  }

  public List<Review> getReviews() {
    return reviews;
  }
}