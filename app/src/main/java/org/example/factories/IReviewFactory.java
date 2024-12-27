package org.example.factories;

import org.example.models.DishReview;
import org.example.models.RestaurantReview;

public interface IReviewFactory {
  DishReview createDishReview(String comment, float rating);

  RestaurantReview createRestaurantReview(String comment, float rating);
}