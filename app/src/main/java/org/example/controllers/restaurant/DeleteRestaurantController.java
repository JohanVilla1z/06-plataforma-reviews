package org.example.controllers.restaurant;

import org.example.controllers.interfaces.ICommandController;
import org.example.services.restaurant.DeleteRestaurantService;

public class DeleteRestaurantController implements ICommandController {
  private final DeleteRestaurantService deleteRestaurantService;

  public DeleteRestaurantController(DeleteRestaurantService deleteRestaurantService) {
    this.deleteRestaurantService = deleteRestaurantService;
  }

  @Override
  public void execute() {
    Boolean isDeleted = deleteRestaurantService.execute();
    if (isDeleted) {
      System.out.println("Restaurante eliminado exitosamente");
    } else {
      System.err.println("No se pudo eliminar el restaurante");
    }
  }
}
