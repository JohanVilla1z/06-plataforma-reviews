package org.example.repositories;

import org.example.models.Dish;
import org.example.models.Menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRepository {

  private static MenuRepository instance;

  private final Map<Integer, Menu> menus;
  private final Map<Integer, Dish> dishes;

  private MenuRepository() {
    menus = new HashMap<>();
    dishes = new HashMap<>();
  }

  public static MenuRepository getInstance() {
    if (instance == null) {
      instance = new MenuRepository();
    }
    return instance;
  }

  public void addMenu(Menu restaurant) {
    menus.put(restaurant.getMenuId(), restaurant);
  }

  public Menu getMenu(Integer name) {
    return menus.get(name);
  }

  public Boolean updateMenu(Menu updatedmenu) {
    Integer menuId = updatedmenu.getMenuId();

    if (menus.containsKey(menuId)) {
      menus.put(menuId, updatedmenu);
      return true;
    }
    return false;
  }

  public void removeMenu(Integer menuId) {
    menus.remove(menuId);
  }

  public List<Menu> getAllMenus() {
    return List.copyOf(menus.values());
  }

  public void addDishToMenu(Dish dish) {
    dishes.put(dish.getDishId(), dish);

  }

  public Boolean updateDish(  Dish dish) {
    Integer dishId = dish.getDishId();

    if (dishes.containsKey(dishId)) {
      dishes.put(dishId, dish);
      return true;
    }
    return false;
  }
}
