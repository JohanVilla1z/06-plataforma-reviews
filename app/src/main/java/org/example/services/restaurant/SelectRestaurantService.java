package org.example.services.restaurant;

import org.example.models.Restaurant;
import org.example.repositories.RestaurantRepository;
import org.example.services.interfaces.ICommand;
import org.example.utils.ConsoleUtils;

import java.util.Map;

public class SelectRestaurantService implements ICommand<Restaurant> {
  private final RestaurantRepository restaurantRepository;
  private final ConsoleUtils consoleUtils;

  public SelectRestaurantService(RestaurantRepository restaurantRepository, ConsoleUtils consoleUtils) {
    this.restaurantRepository = restaurantRepository;
    this.consoleUtils = consoleUtils;
  }

  @Override
  public Restaurant execute() {
    Map<Integer, Restaurant> restaurants = restaurantRepository.getAllRestaurants();
    if (restaurants.isEmpty()) {
      return null;
    }
    printRestaurants(restaurants);
    Integer option = selectRestaurant(restaurants.size());

    return restaurants.get(option - 1);
  }

  public void printRestaurants(Map<Integer, Restaurant> restaurants) {
    System.out.println("Lista de restaurantes: \n ---------------------------------------------------------");
    restaurants.forEach((key, value) ->
            System.out.println(
                    key + 1 + ". " +
                            value.getName() + "\n" +
                            "Ciudad: "+value.getCity() + "\n" +
                            "Puntuacion promedio: ("+value.getAverageRating() + ") Stars\n" +
                            "---------------------------------------------------------")
    );

  }

  public Integer selectRestaurant(Integer size) {

    while (true) {

      Integer option = consoleUtils.getInteger("Seleccione un restaurante: ");
      if (option >= 1 && option <= size) {
        return option;
      }
      System.err.println("Ingrese una opcion valida");
    }
  }
}
