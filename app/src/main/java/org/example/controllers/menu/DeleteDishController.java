package org.example.controllers.menu;

import org.example.controllers.interfaces.ICommandController;
import org.example.services.menu.DeleteDishService;

public class DeleteDishController implements ICommandController {
  private final DeleteDishService deleteDishService;

  public DeleteDishController(DeleteDishService deleteDishService) {
    this.deleteDishService = deleteDishService;
  }

  @Override
  public void execute() {
    deleteDishService.execute();
  }
}
