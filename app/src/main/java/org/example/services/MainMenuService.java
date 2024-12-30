package org.example.services;

import org.example.controllers.RestaurantController;
import org.example.controllers.MenuController;
import org.example.controllers.DishController;
import org.example.services.interfaces.IMainMenuService;
import org.example.utils.ConsoleUtils;

public class MainMenuService implements IMainMenuService {
  private final ConsoleUtils consoleUtils;
  private final RestaurantController restaurantController;
  private final MenuController menuController;
  private final DishController dishController;

  public MainMenuService(
          ConsoleUtils consoleUtils,
          RestaurantController restaurantController,
          MenuController menuController,
          DishController dishController
  ) {
    this.consoleUtils = consoleUtils;
    this.restaurantController = restaurantController;
    this.menuController = menuController;
    this.dishController = dishController;
  }

  @Override
  public void start() {
    int option;
    do {
      System.out.println("=== Menú Principal ===");
      System.out.println("1. Gestionar Restaurantes");
      System.out.println("2. Gestionar Menús");
      System.out.println("3. Gestionar Platos");
      System.out.println("4. Salir");
      option = consoleUtils.getInteger("Selecciona una opción:");

      switch (option) {
        case 1 -> restaurantController.manageRestaurants();
        case 2 -> menuController.manageMenus();
        case 3 -> dishController.manageDishes();
        case 4 -> System.out.println("Saliendo del sistema...");
        default -> System.err.println("Opción no válida.");
      }
    } while (option != 4);
  }
}
