package org.example.controllers.reviews;

import org.example.controllers.interfaces.ICommandController;
import org.example.services.reviews.CreateDishReviewService;

public class CreateDishReviewController implements ICommandController {

  private final CreateDishReviewService createDishReviewService;

  public CreateDishReviewController(CreateDishReviewService createDishReviewService) {
    this.createDishReviewService = createDishReviewService;
  }

  @Override
  public void execute() {
    if (createDishReviewService.execute()) {
      System.out.println("Reseña creada con éxito!!");
    } else {
      System.err.println("No se pudo crear la reseña");
    }
  }
}
