package org.example.services.interfaces;

import org.example.models.Restaurant;

public interface IRestaurantService {
  void addRestaurant(Restaurant restaurant);

  void editRestaurant(String restaurantName, Restaurant updatedRestaurant);

  void removeRestaurant(String restaurantName);

  void listRestaurants();

  void addRestaurantReview(String restaurantName);

  void listRestaurantReviews(String restaurantName);

  void calculateRestaurantAverageRating(String restaurantName);
}
