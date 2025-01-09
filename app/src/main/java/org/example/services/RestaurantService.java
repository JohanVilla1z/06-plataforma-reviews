package org.example.services;

import org.example.factories.ReviewFactory;
import org.example.models.Dish;
import org.example.models.Restaurant;
import org.example.repositories.DataRepository;
import org.example.services.interfaces.IRestaurantService;

public class RestaurantService implements IRestaurantService {
  private final DataRepository repository;
  private final ReviewFactory reviewFactory;

  public RestaurantService(DataRepository dataRepository) {
    this.repository = dataRepository;
    this.reviewFactory = new ReviewFactory();
  }

  @Override
  public void showRestaurants() {
    repository.getAllRestaurants().forEach(System.out::println);
  }

  @Override
  public void addRestaurant(String restaurantName, String restaurantCity, String menuName, String menuDescription) {
    repository.addRestaurant(new Restaurant(restaurantName, restaurantCity));
    repository.addMenuToRestaurant(restaurantName, menuName, menuDescription);
  }

  @Override
  public void addDishToMenu(String menuName, Dish dish) {
    repository.addDishToMenu(menuName, dish);
  }

  @Override
  public void editRestaurant(String restaurantName, Restaurant updatedRestaurant) {
    repository.updateRestaurant(restaurantName, updatedRestaurant);
  }

  @Override
  public void removeRestaurant(String restaurantName) {
    repository.removeRestaurant(restaurantName);
  }

  @Override
  public void listRestaurants() {
    repository.getAllRestaurants().forEach(
            restaurant -> System.out.println(
                    "Restaurante: " + restaurant.getName() +
                            " ubicado en " + restaurant.getCity() +
                            " con " + restaurant.getReviews().size() +
                            " reviews, y calificación promedio de " +
                            restaurant.getAverageRating()
            )
    );
  }

  @Override
  public void addRestaurantReview(String restaurantName, String reviewText, int rating) {
    repository.getRestaurant(restaurantName).addRestaurantReview(
            reviewFactory.createRestaurantReview(reviewText, rating)
    );
  }

  @Override
  public void listRestaurantReviews(String restaurantName) {
    repository.getRestaurant(restaurantName).getReviews().forEach(
            review -> System.out.println("Review: " + review.toString())
    );
  }

  @Override
  public void calculateRestaurantAverageRating(String restaurantName) {
    repository.getRestaurant(restaurantName).calculateAverageRating();
  }
}
