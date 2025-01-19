package org.example.services.menu;

import org.example.models.Dish;
import org.example.repositories.MenuRepository;
import org.example.services.interfaces.ICommand;
import org.example.utils.ConsoleUtils;

public class UpdateDishService implements ICommand<Boolean> {
  private final SelectDishService selectDishService;
  private final MenuRepository menuRepository;
  private final ConsoleUtils consoleUtils;


  public UpdateDishService(SelectDishService selectDishService, ConsoleUtils consoleUtils, MenuRepository menuRepository) {
    this.selectDishService = selectDishService;
    this.menuRepository = menuRepository;
    this.consoleUtils = consoleUtils;
  }

  @Override
  public Boolean execute() {
    Dish dish = selectDishService.execute();


    if (dish == null) {
      System.err.println("No se encontro el plato.");
      return false;
    }

    updateDish(dish);

    return menuRepository.updateDish(dish);
  }

  private void updateDish(Dish dish) {
    System.out.println("Actualizando restaurante (deje vacío para mantener el valor actual): ");
    String name = consoleUtils.getString("Ingrese el nuevo nombre" + " (Valor actual: " + dish.getName() + "): ");
    dish.setName(name.isEmpty() ? dish.getName() : name);
    String description = consoleUtils.getString("Ingrese el nuevo nombre" + " (Valor actual: " + dish.getDescription() + "): ");
    dish.setDescription(description.isEmpty() ? dish.getDescription() : description);
    Float price = consoleUtils.getFloat("Ingrese el nuevo precio" + " (Valor actual: " + dish.getPrice() + "): ");
    dish.setPrice(price == 0 || price == null ? dish.getPrice() : price);
  }

}
