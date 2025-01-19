package org.example.controllers.reviews;

import org.example.controllers.interfaces.ICommandController;
import org.example.services.reviews.CreateRestaurantReviewService;

public class CreateRestaurantReviewController implements ICommandController {
  private final CreateRestaurantReviewService createRestaurantReviewService;

  public CreateRestaurantReviewController(CreateRestaurantReviewService createRestaurantReviewService) {
    this.createRestaurantReviewService = createRestaurantReviewService;
  }

  @Override
  public void execute() {
    if (createRestaurantReviewService.execute()) {
      System.out.println("Reseña creada con éxito!!");
      return;
    }
    System.err.println("Hubo un problema al crear la reseña");
  }
}
