package org.example.controllers;

import org.example.models.Dish;
import org.example.models.Restaurant;
import org.example.services.interfaces.IRestaurantService;
import org.example.utils.ConsoleUtils;

public class RestaurantController {
  private final IRestaurantService restaurantService;
  private final ConsoleUtils consoleUtils;

  public RestaurantController(IRestaurantService restaurantService, ConsoleUtils consoleUtils) {
    this.restaurantService = restaurantService;
    this.consoleUtils = consoleUtils;
  }

  public void manageRestaurants() {
    int option;
    do {
      System.out.println("=== Gestión de Restaurantes ===");
      System.out.println("1. Mostrar restaurantes");
      System.out.println("2. Agregar restaurante");
      System.out.println("3. Editar restaurante");
      System.out.println("4. Eliminar restaurante");
      System.out.println("5. Agregar review");
      System.out.println("6. Listar reviews");
      System.out.println("7. Calcular calificación promedio");
      System.out.println("8. Volver al menú principal");

      option = consoleUtils.getInteger("Selecciona una opción:");

      switch (option) {
        case 1 -> restaurantService.listRestaurants();
        case 2 -> addRestaurant();
        case 3 -> editRestaurant();
        case 4 -> removeRestaurant();
        case 5 -> addReview();
        case 6 -> listReviews();
        case 7 -> calculateAverageRating();
        case 8 -> System.out.println("Volviendo al menú principal...");
        default -> System.err.println("Opción no válida.");
      }
    } while (option != 8);
  }

  private void addRestaurant() {
    String name = consoleUtils.getString("Ingrese el nombre del restaurante:");
    String city = consoleUtils.getString("Ingrese la ciudad del restaurante:");
    String menuName = consoleUtils.getString("Ingrese el nombre del menú:");
    String menuDescription = consoleUtils.getString("Ingrese la descripción del menú:");
    restaurantService.addRestaurant(name, city, menuName, menuDescription);

    int option;
    do {
      option = consoleUtils.getInteger("¿Desea agregar un plato al menú? 1. Sí  2. No");
      if (option == 1) {
        String dishName = consoleUtils.getString("Ingrese el nombre del plato:");
        String dishDescription = consoleUtils.getString("Ingrese la descripción del plato:");
        int dishPrice = consoleUtils.getInteger("Ingrese el precio del plato:");
        restaurantService.addDishToMenu(menuName, new Dish(dishName, dishPrice, dishDescription));
      }
    } while (option != 2);
  }

  private void editRestaurant() {
    String name = consoleUtils.getString("Ingrese el nombre del restaurante a editar:");
    String newName = consoleUtils.getString("Ingrese el nuevo nombre:");
    String newCity = consoleUtils.getString("Ingrese la nueva ciudad:");
    restaurantService.editRestaurant(name, new Restaurant(newName, newCity));
  }

  private void removeRestaurant() {
    String name = consoleUtils.getString("Ingrese el nombre del restaurante a eliminar:");
    restaurantService.removeRestaurant(name);
  }

  private void addReview() {
    String name = consoleUtils.getString("Ingrese el nombre del restaurante:");
    String reviewText = consoleUtils.getString("Escriba el review:");
    int rating = consoleUtils.getInteger("Ingrese la calificación (1-5):");
    restaurantService.addRestaurantReview(name, reviewText, rating);
  }

  private void listReviews() {
    String name = consoleUtils.getString("Ingrese el nombre del restaurante:");
    restaurantService.listRestaurantReviews(name);
  }

  private void calculateAverageRating() {
    String name = consoleUtils.getString("Ingrese el nombre del restaurante:");
    restaurantService.calculateRestaurantAverageRating(name);
  }
}
