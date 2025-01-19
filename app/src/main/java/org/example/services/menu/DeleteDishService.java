package org.example.services.menu;

import org.example.models.Dish;
import org.example.repositories.RestaurantRepository;
import org.example.services.interfaces.ICommand;

public class DeleteDishService implements ICommand<Boolean> {
  private final RestaurantRepository restaurantRepository;
  private final SelectDishService selectDishService;

  public DeleteDishService(RestaurantRepository restaurantRepository, SelectDishService selectDishService) {
    this.restaurantRepository = restaurantRepository;
    this.selectDishService = selectDishService;
  }

  @Override
  public Boolean execute() {
    Dish dish = selectDishService.execute();

    if (dish == null) {
      System.out.println("No se encontro el platillo");
      return false;
    }
    return restaurantRepository.getAllRestaurants().values().stream()
        .anyMatch(restaurant -> restaurant.getMenu().getDishes().remove(dish));
  }
}
