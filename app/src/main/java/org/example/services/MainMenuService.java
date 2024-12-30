package org.example.services;

import org.example.controllers.RestaurantController;
import org.example.controllers.MenuController;
import org.example.controllers.DishController;
import org.example.services.interfaces.IMainMenuService;

public class MainMenuService implements IMainMenuService {
  private final RestaurantController restaurantController;
  private final MenuController menuController;
  private final DishController dishController;

  public MainMenuService(
          RestaurantController restaurantController,
          MenuController menuController,
          DishController dishController
  ) {
    this.restaurantController = restaurantController;
    this.menuController = menuController;
    this.dishController = dishController;
  }

  @Override
  public void manageRestaurants() {
    restaurantController.manageRestaurants();
  }

  @Override
  public void manageMenus() {
    menuController.manageMenus();
  }

  @Override
  public void manageDishes() {
    dishController.manageDishes();
  }
}
