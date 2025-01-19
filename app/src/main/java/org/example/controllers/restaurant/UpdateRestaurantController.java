package org.example.controllers.restaurant;

import org.example.controllers.interfaces.ICommandController;
import org.example.services.restaurant.UpdateRestaurantService;

public class UpdateRestaurantController implements ICommandController {
  private final UpdateRestaurantService updateRestaurantService;

  public UpdateRestaurantController(UpdateRestaurantService updateRestaurantService) {
    this.updateRestaurantService = updateRestaurantService;
  }


  @Override
  public void execute() {
    Boolean isUpdated = updateRestaurantService.execute();

    if (isUpdated) {
      System.out.println("Restaurante actualizado correctamente");
      return;
    }
    System.out.println("No se pudo actualizar el restaurante");

  }
}
