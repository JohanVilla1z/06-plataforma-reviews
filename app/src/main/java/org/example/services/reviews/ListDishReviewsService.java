package org.example.services.reviews;

import org.example.models.Dish;
import org.example.models.DishReview;
import org.example.services.interfaces.ICommand;
import org.example.services.menu.SelectDishService;

import java.util.List;

public class ListDishReviewsService implements ICommand<List<DishReview>> {
  private final SelectDishService selectDishService;

  public ListDishReviewsService(SelectDishService selectDishService) {
    this.selectDishService = selectDishService;
  }

  @Override
  public List<DishReview> execute() {

    Dish selectedDish = selectDishService.execute();

    if (selectedDish == null) {
      return List.of();
    }

    List<DishReview> dishReviewList = selectedDish.getReviews().stream().map(DishReview.class::cast).toList();
    return dishReviewList;
  }
}
