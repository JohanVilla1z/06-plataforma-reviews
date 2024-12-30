
package org.example;

import org.example.controllers.DishController;
import org.example.controllers.MainMenuController;
import org.example.controllers.MenuController;
import org.example.controllers.RestaurantController;
import org.example.repositories.DataRepository;
import org.example.services.MainMenuService;
import org.example.services.RestaurantService;
import org.example.utils.ConsoleUtils;

public class Main {

  public static void main(String[] args) {
    DataRepository dataRepository = DataRepository.getInstance();
    ConsoleUtils consoleUtils = new ConsoleUtils();
    DishController dishController = new DishController();
    MenuController menuController = new MenuController();
    RestaurantService restaurantService = new RestaurantService(dataRepository);
    RestaurantController restaurantController = new RestaurantController(restaurantService);
    MainMenuController mainMenuController = new MainMenuController(
            new MainMenuService(consoleUtils, restaurantController, menuController, dishController)
    );
    mainMenuController.run();
  }
}
