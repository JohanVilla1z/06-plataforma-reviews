package org.example.models;

public class RestaurantReview extends Review {
  private Float serviceRating;
  private Float environmentRating;
  private Float menuRating;

  public RestaurantReview(String comment, Float serviceRating, Float environmentRating, Float menuRating) {
    super(comment);
    this.serviceRating = serviceRating;
    this.environmentRating = environmentRating;
    this.menuRating = menuRating;
  }

  public RestaurantReview(String comment, Float rating) {
    super(comment);
  }

  @Override
  public void setAverageRating(Float averageRating) {
    super.setAverageRating(averageRating);
  }

  @Override
  public Integer getReviewId() {
    return super.getReviewId();
  }

  @Override
  public void setReviewId(Integer reviewId) {
    super.setReviewId(reviewId);
  }

  @Override
  public void setComment(String comment) {
    super.setComment(comment);
  }

  @Override
  public Float getAverageRating() {
    return super.getAverageRating();
  }

  @Override
  public String getComment() {
    return super.getComment();
  }

  @Override
  public String toString() {
    return super.toString();
  }

  @Override
  public void calculateRating() {
    Float average = (serviceRating + environmentRating + menuRating) / 3;
    this.setAverageRating(Math.round(average * 100.0) / 100.0F);
  }
}