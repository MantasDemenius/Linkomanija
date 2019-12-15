package com.linkomanija.backend.dto;

public class MovieRatingDTO {
  private Long id;
  private double rating;
  private Long movie_id;

  public Long getId() {
    return id;
  }

  public double getRating() {
    return rating;
  }

  public Long getMovie_id() {
    return movie_id;
  }
}
