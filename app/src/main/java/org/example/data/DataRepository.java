package org.example.data;

import org.example.models.Dish;
import org.example.models.Menu;
import org.example.models.Restaurant;
import org.example.models.Review;

import java.util.*;

public class DataRepository {
  private static DataRepository instance;

  private final Map<String, Restaurant> restaurants; // key: nombre del restaurante
  private final Map<String, Menu> menus;             // key: nombre del menú
  private final Map<String, Dish> dishes;            // key: nombre del plato
  private final List<Review> reviews;

  // Constructor privado
  private DataRepository() {
    this.restaurants = new HashMap<>();
    this.menus = new HashMap<>();
    this.dishes = new HashMap<>();
    this.reviews = new LinkedList<>();
  }

  public static DataRepository getInstance() {
    if (instance == null) {
      instance = new DataRepository();
    }
    return instance;
  }

  public void addRestaurant(Restaurant restaurant) {
    restaurants.put(restaurant.getName(), restaurant);
  }

  public Restaurant getRestaurant(String name) {
    return restaurants.get(name);
  }

  public void removeRestaurant(String name) {
    restaurants.remove(name);
  }

  public List<Restaurant> getAllRestaurants() {
    return new ArrayList<>(restaurants.values());
  }

  // menus
  public void addMenu(Menu menu) {
    menus.put(menu.getName(), menu);
  }

  public Menu getMenu(String name) {
    return menus.get(name);
  }

  public void removeMenu(String name) {
    menus.remove(name);
  }

  public List<Menu> getAllMenus() {
    return new ArrayList<>(menus.values());
  }

  // platos
  public void addDish(Dish dish) {
    dishes.put(dish.getName(), dish);
  }

  public Dish getDish(String name) {
    return dishes.get(name);
  }

  public void removeDish(String name) {
    dishes.remove(name);
  }

  public List<Dish> getAllDishes() {
    return new ArrayList<>(dishes.values());
  }

  //reviews
  public void addReview(Review review) {
    reviews.add(review);
  }

  public List<Review> getAllReviews() {
    return new ArrayList<>(reviews);
  }
}
