package com.linkomanija.backend.domain;

import com.linkomanija.backend.dto.MovieRatingDTO;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "movie_user_rating")
public class MovieRating {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private double rating;

  @JoinColumn(name = "movie_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private Movie movie;

  public MovieRating(MovieRatingDTO movieRatingDTO, Movie movie) {
    this.rating = movieRatingDTO.getRating();
    this.movie = movie;
  }

  public MovieRating() {}

  public double getRating() {
    return rating;
  }
}
