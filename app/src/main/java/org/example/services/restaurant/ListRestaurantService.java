package org.example.services.restaurant;

import org.example.models.Restaurant;
import org.example.repositories.RestaurantRepository;
import org.example.services.interfaces.ICommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListRestaurantService implements ICommand<List<Restaurant>> {
  private final RestaurantRepository restaurantRepository;

  public ListRestaurantService(RestaurantRepository restaurantRepository) {
    this.restaurantRepository = restaurantRepository;
  }

  @Override
  public List<Restaurant> execute() {
    Map<Integer, Restaurant> restaurants = restaurantRepository.getAllRestaurants();

    return new ArrayList<>(restaurants.values());
  }
}
