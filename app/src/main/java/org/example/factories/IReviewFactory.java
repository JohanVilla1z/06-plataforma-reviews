package org.example.factories;

import org.example.models.DishReview;
import org.example.models.RestaurantReview;

public interface IReviewFactory {
  DishReview createDishReview(String comment, Float presentationRating, Float tasteRating);

  RestaurantReview createRestaurantReview(String comment, Float serviceRating, Float environmentRating, Float MenuRating);
}