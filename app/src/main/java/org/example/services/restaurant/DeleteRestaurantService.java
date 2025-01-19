package org.example.services.restaurant;

import org.example.models.Restaurant;
import org.example.repositories.RestaurantRepository;
import org.example.services.interfaces.ICommand;

public class DeleteRestaurantService implements ICommand<Boolean> {
  private final RestaurantRepository restaurantRepository;
  private final SelectRestaurantService selectRestaurantService;

  public DeleteRestaurantService(RestaurantRepository restaurantRepository, SelectRestaurantService selectRestaurantService) {
    this.selectRestaurantService = selectRestaurantService;
    this.restaurantRepository = restaurantRepository;
  }

  @Override
  public Boolean execute() {
    Restaurant restaurant = selectRestaurantService.execute();

    if (restaurant == null) {
      return false;
    }

    return restaurantRepository.removeRestaurant(restaurant.getRestaurantId());
  }
}
