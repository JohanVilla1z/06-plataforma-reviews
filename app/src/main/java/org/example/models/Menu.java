package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Menu {
  private Integer menuId;
  private String name;
  private String description;
  private List<Dish> dishes;

  private static Integer idCounter = 0;

  public Menu(String name, String description) {
    this.menuId = generateId();
    this.name = name;
    this.description = description;
    this.dishes = new ArrayList<>();
  }

  public Menu(String name, String description, List<Dish> dishes) {
    this.menuId = generateId();
    this.name = name;
    this.description = description;
    this.dishes = dishes;
  }

  public Menu() {
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

  public void setDishes(List<Dish> dishes) {
    this.dishes = dishes;
  }

  public String getName() {
    return name;
  }
}