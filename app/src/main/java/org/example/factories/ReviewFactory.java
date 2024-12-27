package org.example.factories;

import org.example.models.DishReview;
import org.example.models.RestaurantReview;

public class ReviewFactory implements IReviewFactory {
  @Override
  public DishReview createDishReview(String comment, float rating) {
    return new DishReview(comment, rating);
  }

  @Override
  public RestaurantReview createRestaurantReview(String comment, float rating) {
    return new RestaurantReview(comment, rating);
  }
}