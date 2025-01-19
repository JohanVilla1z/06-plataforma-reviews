package org.example.repositories;

import org.example.models.Restaurant;
import org.example.models.RestaurantReview;

import java.util.HashMap;
import java.util.Map;

public class RestaurantRepository {

  private static RestaurantRepository instance;
  private Map<Integer, Restaurant> restaurants;

  private RestaurantRepository() {
    this.restaurants = new HashMap<>();
  }

  public static RestaurantRepository getInstance() {
    if (instance == null) {
      instance = new RestaurantRepository();
    }
    return instance;
  }

  public Boolean updateRestaurant(Restaurant updatedRestaurant) {
    Integer restaurantId = updatedRestaurant.getRestaurantId();

    if (restaurants.containsKey(restaurantId)) {
      restaurants.put(restaurantId, updatedRestaurant);
      return true;
    }
    return false;
  }

  public void addRestaurant(Restaurant restaurant) {
    restaurants.put(restaurant.getRestaurantId(), restaurant);
  }

  public Restaurant getRestaurant(Integer restaurantId) {
    return restaurants.get(restaurantId);
  }

  public Boolean removeRestaurant(Integer id) {
    return restaurants.remove(id) != null;
  }

  public Map<Integer, Restaurant> getAllRestaurants() {
    return restaurants;
  }

  public void addRestaurantReview(Integer restaurantId, RestaurantReview review) {
    Restaurant restaurant = restaurants.get(restaurantId);
    restaurant.addReview(review);
  }
}
