package org.example.models;

public abstract class Review {
  protected String comment;
  protected float rating;

  public Review(String comment, float rating) {
    this.comment = comment;
    this.rating = rating;
  }

  public float getRating() {
    return rating;
  }

  @Override
  public String toString() {
    return "Rating: " + rating + " - " + comment;
  }
}