package org.example.controllers.restaurant;

import org.example.controllers.interfaces.ICommandController;
import org.example.models.Restaurant;
import org.example.services.restaurant.ListRestaurantService;
import org.example.utils.ConsoleUtils;

import java.util.List;

public class ListRestaurantController implements ICommandController {
  private final ListRestaurantService listRestaurantService;
  private final ConsoleUtils consoleUtils;

  public ListRestaurantController(ListRestaurantService listRestaurantService, ConsoleUtils consoleUtils) {
    this.listRestaurantService = listRestaurantService;
    this.consoleUtils = consoleUtils;
  }

  @Override
  public void execute() {
    List<Restaurant> restaurants = listRestaurantService.execute();

    if (restaurants.isEmpty()) {
      System.out.println("No se encontraron restaurantes");
      return;
    }
    showList(restaurants);

  }

  private void showList(List<Restaurant> restaurants) {
    System.out.println("Lista de restaurantes: ");


    restaurants.forEach(r -> System.out.println(r.toString()));

  }
}
