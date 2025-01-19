package org.example.models;

public class DishReview extends Review {
  private Float presentationRating;
  private Float tasteRating;

  public DishReview(String comment, Float presentationRating, Float tasteRating) {
    super(comment);
    this.presentationRating = presentationRating;
    this.tasteRating = tasteRating;
    calculateRating();
  }

  @Override
  public void calculateRating() {
    Float average = (tasteRating + presentationRating) / 2;
    this.setAverageRating(Math.round(average * 100.0) / 100.0F);
  }

  @Override
  public String toString() {
    return "Review de plato: " +
            "\n    Presentacion: " + presentationRating +
            "\n    Sabor: " + tasteRating;
  }

  public Float getPresentationRating() {
    return presentationRating;
  }

  public void setPresentationRating(Float presentationRating) {
    this.presentationRating = presentationRating;
  }

  public Float getTasteRating() {
    return tasteRating;
  }

  public void setTasteRating(Float tasteRating) {
    this.tasteRating = tasteRating;
  }

}