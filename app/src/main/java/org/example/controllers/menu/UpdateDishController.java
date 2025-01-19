package org.example.controllers.menu;

import org.example.controllers.interfaces.ICommandController;
import org.example.services.menu.UpdateDishService;

public class UpdateDishController implements ICommandController {
  private final UpdateDishService updateDishService;

  public UpdateDishController(UpdateDishService updateDishService) {
    this.updateDishService = updateDishService;
  }

  @Override
  public void execute() {
    Boolean dishUpdated = updateDishService.execute();

    if (dishUpdated) {
      System.out.println("Plato actualizado exitosamente");
    } else {
      System.out.println("No se pudo actualizar el plato");
    }
  }
}
