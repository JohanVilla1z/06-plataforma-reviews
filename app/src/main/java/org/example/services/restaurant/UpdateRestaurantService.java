package org.example.services.restaurant;

import org.example.models.Restaurant;
import org.example.repositories.RestaurantRepository;
import org.example.services.interfaces.ICommand;
import org.example.utils.ConsoleUtils;

public class UpdateRestaurantService implements ICommand<Boolean> {
  private final SelectRestaurantService selectRestaurantService;
  private final RestaurantRepository restaurantRepository;
  private final ConsoleUtils consoleUtils;

  public UpdateRestaurantService(SelectRestaurantService selectRestaurantService, RestaurantRepository restaurantRepository, ConsoleUtils consoleUtils) {
    this.selectRestaurantService = selectRestaurantService;
    this.restaurantRepository = restaurantRepository;
    this.consoleUtils = consoleUtils;
  }


  @Override
  public Boolean execute() {
    Restaurant restaurant = selectRestaurantService.execute();

    if (restaurant == null) {
      System.err.println("No se selecciono ningun restaurante.");
      return false;
    }
    updateRestaurant(restaurant);

    return restaurantRepository.updateRestaurant(restaurant);
  }

  private void updateRestaurant(Restaurant restaurant) {
    System.out.println("Actualizando restaurante (deje vacío para mantener el valor actual): ");
    String name = consoleUtils.getString("Ingrese el nuevo nombre" + " (Valor actual: " + restaurant.getName() + "): ");
    restaurant.setName(name.isEmpty() ? restaurant.getName() : name);
    String city = consoleUtils.getString("Ingrese la nueva ciudad del restaurante" + " (Valor actual: " + restaurant.getCity() + "): ");
    restaurant.setCity(city.isEmpty() ? restaurant.getCity() : city);

  }
}
