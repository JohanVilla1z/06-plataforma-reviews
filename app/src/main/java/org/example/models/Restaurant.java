package org.example.models;

import org.example.models.interfaces.IObservable;
import org.example.models.interfaces.IObserver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Restaurant implements IObservable {
  private Integer restaurantId;
  private String name;
  private String city;
  private Menu menu;
  private List<Review> reviews;
  private Float averageRating;

  private final Set<IObserver> observerSet = new HashSet<>();

  private static Integer idCounter = 0;

  public Restaurant(String name, String city, Menu menu) {
    this.restaurantId = generateId();
    this.name = name;
    this.city = city;
    this.menu = menu;
    this.reviews = new ArrayList<>();
    this.averageRating = calculateAverageRating();
  }

  public Restaurant(String name, String city) {
    this.name = name;
    this.city = city;
    this.menu = new Menu();
    this.reviews = new ArrayList<>();
    this.averageRating = calculateAverageRating();
  }

  public Restaurant() {
  }

  private Integer generateId() {
    return idCounter++;
  }

  @Override
  public void addObserver(IObserver observer) {
    observerSet.add(observer);
  }

  @Override
  public void notifyObservers(String message) {
    observerSet.forEach(observer -> observer.update(message));
  }

  public Float calculateAverageRating() {
    Float average = (float) reviews.stream().mapToDouble(Review::getAverageRating).average().orElse(0);
    this.notifyObservers("La calificación promedio del restaurante " + name + " ha cambiado a " + average);
    return reviews.isEmpty() ? 0 : average;
  }

  public void addReview(Review review) {
    reviews.add(review);
    calculateAverageRating();
  }

  public void addRestaurantReview(Review review) {
    if (review instanceof RestaurantReview) {
      reviews.add(review);
      calculateAverageRating();
    }
  }

  @Override
  public String toString() {
    StringBuilder restaurantString = new StringBuilder("\n=======================================================\n");
    restaurantString
            .append("Nombre: ").append(name).append("\n")
            .append("Ciudad: ").append(city).append("\n")
            .append("Puntuacion promedio: (").append(getAverageRating()).append(") Stars\n")
            .append("Menu: ").append(menu.getName()).append("\n")
            .append("Platos: \n");

    for (Dish dish : menu.getDishes()) {
      restaurantString.append(dish.toString()).append("\n");
    }
    return restaurantString.toString();
  }

  public Integer getRestaurantId() {
    return restaurantId;
  }

  public void setRestaurantId(Integer restaurantId) {
    this.restaurantId = restaurantId;
  }

  public String getName() {
    return name;
  }

  public String getCity() {
    return city;
  }

  public Menu getMenu() {
    return menu;
  }

  public Float getAverageRating() {
    return averageRating;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }

  public void setAverageRating(Float averageRating) {
    this.averageRating = averageRating;
  }

  public List<Review> getReviews() {
    return reviews;
  }
}