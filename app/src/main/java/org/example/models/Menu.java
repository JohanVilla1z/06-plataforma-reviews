package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Menu {
  private String name;
  private List<Dish> dishes;

  public Menu(String name) {
    this.name = name;
    this.dishes = new ArrayList<>();
  }

  public void addDish(Dish dish) {
    dishes.add(dish);
  }

  public void removeDish(String dishName) {
    dishes.removeIf(dish -> dish.getName().equalsIgnoreCase(dishName));
  }

  public void editDish(String dishName, Dish updatedDish) {
    for (int i = 0; i < dishes.size(); i++) {
      if (dishes.get(i).getName().equalsIgnoreCase(dishName)) {
        dishes.set(i, updatedDish);
        break;
      }
    }
  }

  public List<Dish> getDishes() {
    return dishes;
  }
}