package org.example.controllers;

import org.example.services.interfaces.IMainMenuService;
import org.example.utils.ConsoleUtils;

public class MainMenuController {
  private final IMainMenuService mainMenuService;
  private final ConsoleUtils consoleUtils;

  public MainMenuController(IMainMenuService mainMenuService, ConsoleUtils consoleUtils) {
    this.mainMenuService = mainMenuService;
    this.consoleUtils = consoleUtils;
  }

  public void run() {
    int option;
    do {
      System.out.println("=== Menú Principal ===");
      System.out.println("1. Gestionar Restaurantes");
      System.out.println("2. Gestionar Menús");
      System.out.println("3. Gestionar Platos");
      System.out.println("4. Salir");

      option = consoleUtils.getInteger("Selecciona una opción:");

      switch (option) {
        case 1 -> mainMenuService.manageRestaurants();
        case 2 -> mainMenuService.manageMenus();
        case 3 -> mainMenuService.manageDishes();
        case 4 -> System.out.println("Saliendo del sistema...");
        default -> System.err.println("Opción no válida.");
      }
    } while (option != 4);
  }
}
