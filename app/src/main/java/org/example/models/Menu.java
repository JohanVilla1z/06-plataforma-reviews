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
    this.dishes = new ArrayList<>(); 
  }

  private Integer generateId() {
    return idCounter++;
  }

  public static Integer getIdCounter() {
    return idCounter;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb
            .append(name).append("\n")
            .append(description).append("\n")
            .append("Platos: ").append("\n")
            .append(dishes.stream().map(dish -> dish.toString())).append("\n");


    return sb.toString();
  }

  public static void setIdCounter(Integer idCounter) {
    Menu.idCounter = idCounter;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getMenuId() {
    return menuId;
  }

  public void setMenuId(Integer menuId) {
    this.menuId = menuId;
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