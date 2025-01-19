package org.example.factories;

import org.example.models.DishReview;
import org.example.models.RestaurantReview;

public class ReviewFactory implements IReviewFactory {

  @Override
  public DishReview createDishReview(String comment, Float presentationRating, Float tasteRating) {
    return new DishReview(comment, presentationRating, tasteRating);
  }

  @Override
  public RestaurantReview createRestaurantReview(String comment, Float serviceRating, Float environmentRating, Float menuRating) {
    return new RestaurantReview(comment, serviceRating, environmentRating, menuRating);
  }
}