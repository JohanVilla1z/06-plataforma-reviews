
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

    RestaurantService restaurantService = new RestaurantService(dataRepository);

    DishController dishController = new DishController();
    MenuController menuController = new MenuController();
    RestaurantController restaurantController = new RestaurantController(restaurantService);
    MainMenuController mainMenuController = new MainMenuController(
            new MainMenuService(restaurantController, menuController, dishController),
            consoleUtils
    );
    mainMenuController.run();
  }
}
