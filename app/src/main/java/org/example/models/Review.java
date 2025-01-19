package org.example.models;

public abstract class Review {
  protected Integer reviewId;
  protected String comment;
  protected Float averageRating;

  protected static Integer reviewCount = 0;

  public Review(String comment) {
    this.reviewId = generateId();
    this.comment = comment;
    this.averageRating = 0f;
  }

  private Integer generateId() {
    return reviewCount++;
  }

  public void setAverageRating(Float averageRating) {
    this.averageRating = averageRating;
  }

  public Integer getReviewId() {
    return reviewId;
  }

  public void setReviewId(Integer reviewId) {
    this.reviewId = reviewId;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public static Integer getReviewCount() {
    return reviewCount;
  }

  public static void setReviewCount(Integer reviewCount) {
    Review.reviewCount = reviewCount;
  }

  public Float getAverageRating() {
    return averageRating;
  }

  public String getComment() {
    return comment;
  }

  public abstract void calculateRating();
}