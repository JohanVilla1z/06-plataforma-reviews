package org.example.controllers.menu;

import org.example.controllers.interfaces.ICommandController;
import org.example.models.Menu;
import org.example.services.menu.AddDishService;

public class AddDishController implements ICommandController {
  private final AddDishService addDishService;

  public AddDishController(AddDishService addDishService) {
    this.addDishService = addDishService;
  }

  @Override
  public void execute() {
    Menu menu = addDishService.execute();
    if (menu != null) {
      System.out.println("Platillo agregado correctamente al menu");
    } else {
      System.err.println("No se pudo agregar el platillo al menu");
    }
  }
}
