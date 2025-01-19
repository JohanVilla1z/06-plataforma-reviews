package org.example.services.menu;

import org.example.models.Dish;
import org.example.models.Menu;
import org.example.models.Restaurant;
import org.example.repositories.MenuRepository;
import org.example.services.interfaces.ICommand;
import org.example.services.restaurant.SelectRestaurantService;
import org.example.utils.ConsoleUtils;

import java.util.ArrayList;

public class AddDishService implements ICommand<Menu> {
  private final SelectRestaurantService selectRestaurantService;
  private final MenuRepository menuRepository;
  private final ConsoleUtils consoleUtils;

  public AddDishService(SelectRestaurantService selectRestaurantService, MenuRepository menuRepository, ConsoleUtils consoleUtils) {
    this.selectRestaurantService = selectRestaurantService;
    this.menuRepository = menuRepository;
    this.consoleUtils = consoleUtils;
  }

  @Override
  public Menu execute() {
    System.out.println("Creando el menu para el restaurante...");
    Restaurant restaurant = selectRestaurantService.execute();
    Menu menu = restaurant.getMenu();

    if (menu == null) {
      menu = createMenu();
      restaurant.setMenu(menu);
      menuRepository.addMenu(menu);
    }

    addDishesToMenu(menu);
    System.out.println("Menu " + menu.getName() + " creado exitosamente!");
    return menu;
  }

  private Menu createMenu() {
    System.out.println("Creando un nuevo menu...");
    String name = consoleUtils.getString("Ingrese el nombre del menu: ");
    String description = consoleUtils.getString("Ingrese la descripcion del menu: ");
    return new Menu(name, description, new ArrayList<>());
  }

  private void addDishesToMenu(Menu menu) {
    Boolean option = true;
    while (option) {
      addDish(menu);
      option = consoleUtils.getBoolean("Desea agregar otro plato al menu? (Si/No): ");
    }
  }

  private void addDish(Menu menu) {
    String name = consoleUtils.getString("Ingrese el nombre del plato: ");
    String description = consoleUtils.getString("Ingrese la descripcion del plato: ");
    Float price = consoleUtils.getFloat("Ingrese el precio del plato: ");
    Dish dish = new Dish(name, description, price);
    menuRepository.addDishToMenu(dish);
    menu.addDish(dish);
    System.out.println("Plato agregado al menu exitosamente!");
  }
}
