package org.example.services.reviews;

import org.example.factories.ReviewFactory;
import org.example.models.Dish;
import org.example.models.Review;
import org.example.services.interfaces.ICommand;
import org.example.services.menu.SelectDishService;
import org.example.utils.ConsoleUtils;

public class CreateDishReviewService implements ICommand<Boolean> {
  private final SelectDishService selectDishService;
  private final ConsoleUtils consoleUtils;
  private final ReviewFactory reviewFactory;


  public CreateDishReviewService(SelectDishService selectDishService, ConsoleUtils consoleUtils, ReviewFactory reviewFactory) {
    this.selectDishService = selectDishService;
    this.consoleUtils = consoleUtils;
    this.reviewFactory = reviewFactory;
  }

  @Override
  public Boolean execute() {
    Dish dish = selectDishService.execute();

    if (dish == null) {
      System.err.println("Algo ha fallado seleccionado un plato.");
      return false;
    }

    Review review = createReview();

    dish.addReview(review);

    return true;
  }

  private Review createReview() {
    System.out.println("Creando una reseña...");
    String comment = consoleUtils.getString("Ingrese un comentario para reseñar el plato: ");
    Float presentationRating = consoleUtils.getRating("Ingrese la puntuacion que le da a la presentacion del plato: ");
    Float tasteRating = consoleUtils.getRating("Ingrese la puntuacion que le da al sabor del plato: ");
    return reviewFactory.createDishReview(comment, presentationRating, tasteRating);
  }
}
