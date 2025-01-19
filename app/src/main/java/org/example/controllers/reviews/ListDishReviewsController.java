package org.example.controllers.reviews;

import org.example.controllers.interfaces.ICommandController;
import org.example.models.DishReview;
import org.example.services.reviews.ListDishReviewsService;

import java.util.List;

public class ListDishReviewsController implements ICommandController {
  private final ListDishReviewsService listDishReviewsService;

  public ListDishReviewsController(ListDishReviewsService listDishReviewsService) {
    this.listDishReviewsService = listDishReviewsService;
  }

  @Override
  public void execute() {
    List<DishReview> reviews = listDishReviewsService.execute();
    if (reviews.isEmpty()) {
      System.out.println("No hay reseñas para este platillo");
      return;
    }
    reviews.forEach(review -> System.out.println(review.toString()));
  }
}
