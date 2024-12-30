package org.example.services.interfaces;

import org.example.models.Dish;

public interface IDishService {
  void addDish(String menuName, Dish dish);

  void editDish(String menuName, String dishName, Dish updatedDish);

  void removeDish(String menuName, String dishName);

  void listDishes(String menuName);

  void addDishReview(String menuName, String dishName);

  void listDishReviews(String menuName, String dishName);

  void calculateDishAverageRating(String menuName, String dishName);
}
