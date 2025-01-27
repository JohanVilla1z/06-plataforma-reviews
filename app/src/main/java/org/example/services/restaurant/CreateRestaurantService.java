package org.example.services.restaurant;

import org.example.models.Menu;
import org.example.models.Restaurant;
import org.example.repositories.RestaurantRepository;
import org.example.services.interfaces.ICommand;
import org.example.services.menu.AddDishService;
import org.example.utils.ConsoleUtils;

public class CreateRestaurantService implements ICommand<Restaurant> {
  private final RestaurantRepository restaurantRepository;
  private final ConsoleUtils consoleUtils;
  private final AddDishService addDishService;

  public CreateRestaurantService(RestaurantRepository restaurantRepository, ConsoleUtils consoleUtils, AddDishService addDishService) {
    this.restaurantRepository = restaurantRepository;
    this.consoleUtils = consoleUtils;
    this.addDishService = addDishService;
  }

  @Override
  public Restaurant execute() {
    System.out.println("Creando un restaurante...");
    String name = consoleUtils.getString("Ingrese el nombre del restaurante: ");
    String city = consoleUtils.getString("Ingrese la ciudad del restaurante: ");

    Restaurant restaurant = new Restaurant(name, city, null);
    restaurantRepository.addRestaurant(restaurant);
    System.out.println("Restaurante creado con éxito: " + restaurant.getName() + "\n");

    Menu menu = addDishService.execute();

    restaurant.setMenu(menu);

    return restaurant;
  }
}
