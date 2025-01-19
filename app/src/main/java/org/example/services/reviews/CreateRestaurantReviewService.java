package org.example.services.reviews;

import org.example.factories.ReviewFactory;
import org.example.models.Restaurant;
import org.example.models.Review;
import org.example.services.interfaces.ICommand;
import org.example.services.restaurant.SelectRestaurantService;
import org.example.utils.ConsoleUtils;

public class CreateRestaurantReviewService implements ICommand<Boolean> {
  private final SelectRestaurantService selectRestaurantService;
  private final ReviewFactory reviewFactory;
  private final ConsoleUtils consoleUtils;

  public CreateRestaurantReviewService(SelectRestaurantService selectRestaurantService, ReviewFactory reviewFactory, ConsoleUtils consoleUtils) {
    this.selectRestaurantService = selectRestaurantService;
    this.reviewFactory = reviewFactory;
    this.consoleUtils = consoleUtils;
  }


  @Override
  public Boolean execute() {

    Restaurant restaurant = selectRestaurantService.execute();

    if (restaurant == null) {
      System.err.println("No hay restaurantes para calificar");
      return false;
    }

    Review review = createReview();

    restaurant.addReview(review);

    return true;
  }

  private Review createReview() {
    String comment = consoleUtils.getString("Ingrese un comentario para el restaurante: ");
    Float serviceRating = consoleUtils.getRating("Ingrese una calificacion para el servicio del restaurante (0-5): ");
    Float environmentRating = consoleUtils.getRating("Ingrese una calificacion para el ambiente del restaurante (0-5): ");
    Float menuRating = consoleUtils.getRating("Ingrese una calificacion para el menu del restaurante (0-5): ");

    return reviewFactory.createRestaurantReview(comment, serviceRating, environmentRating, menuRating);
  }
}
