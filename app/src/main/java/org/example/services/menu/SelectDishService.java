package org.example.services.menu;

import org.example.models.Dish;
import org.example.models.Restaurant;
import org.example.services.interfaces.ICommand;
import org.example.services.restaurant.SelectRestaurantService;
import org.example.utils.ConsoleUtils;

import java.util.List;

public class SelectDishService implements ICommand<Dish> {
  private final ConsoleUtils consoleUtils;
  private final SelectRestaurantService selectRestaurantService;


  public SelectDishService(ConsoleUtils consoleUtils, SelectRestaurantService selectRestaurantService) {
    this.consoleUtils = consoleUtils;
    this.selectRestaurantService = selectRestaurantService;
  }


  @Override
  public Dish execute() {

    Restaurant restaurant = selectRestaurantService.execute();
    List<Dish> dishes = restaurant.getMenu().getDishes();

    if (dishes.isEmpty()) {
      System.err.println("No se han encontrado platos en el menu del restaurante seleccionado");
      return null;
    }

    printDishes(dishes);
    return dishes.get(selectDish(dishes.size()));
  }

  private void printDishes(List<Dish> dishes) {
    System.out.println("Platos disponibles: \n ---------------------------------------------------------");
    dishes.forEach(dish -> System.out.println((dishes.indexOf(dish) + 1) + ". " + dish.getName() + "\n---------------------------------------------------------")
    );
  }

  private Integer selectDish(Integer size) {
    Integer option = consoleUtils.getInteger("Seleccione un plato: ");
    if (option < 1 || option > size) {
      System.err.println("Ingrese una opcion valida de 1 a " + size);
      selectDish(size);
    }
    return option - 1;
  }
}
