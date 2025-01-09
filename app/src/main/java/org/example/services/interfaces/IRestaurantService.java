package org.example.services.interfaces;

import org.example.models.Dish;
import org.example.models.Restaurant;

public interface IRestaurantService {

  void editRestaurant(String restaurantName, Restaurant updatedRestaurant);

  void removeRestaurant(String restaurantName);

  void listRestaurants();

  void listRestaurantReviews(String restaurantName);

  void calculateRestaurantAverageRating(String restaurantName);

  void addRestaurantReview(String name, String reviewText, int rating);

  void addDishToMenu(String menuName, Dish dish);

  void showRestaurants();

  void addRestaurant(String name, String city, String menuName, String menuDescription);
}
