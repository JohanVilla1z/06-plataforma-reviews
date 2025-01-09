package org.example.models;

public abstract class Review {
  protected String comment;
  protected Float rating;

  public Review(String comment, Float rating) {
    this.comment = comment;
    this.rating = rating;
  }

  public Float getRating() {
    return rating;
  }

  public String getComment() {
    return comment;
  }

  @Override
  public String toString() {
    return "Rating: " + rating + " - " + comment;
  }
}