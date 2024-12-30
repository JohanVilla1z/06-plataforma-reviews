package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Dish {
  private String name;
  private Float price;
  private String description;
  private List<Review> reviews;

  public Dish(String name, float price, String description) {
    this.name = name;
    this.price = price;
    this.description = description;
    this.reviews = new ArrayList<>();
  }

  public Float averageRating() {
    Float total = 0f;
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