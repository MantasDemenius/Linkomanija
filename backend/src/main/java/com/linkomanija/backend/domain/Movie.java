package com.linkomanija.backend.domain;

import com.linkomanija.backend.dto.MovieDTO;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "movie")
public class Movie {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String poster_url;
  private Date release_date;
  private String description;
  private int movie_length;
  private String creation_country;
  private String age_censor;
  private String imdb_code;
  private double rating;

  @JoinColumn(name = "language_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private Language language;

  public Movie(MovieDTO movieDTO) {
    this.title = movieDTO.getTitle();
    this.poster_url = movieDTO.getPoster_url();
    this.release_date = movieDTO.getRelease_date();
    this.description = movieDTO.getDescription();
    this.movie_length = movieDTO.getMovie_length();
    this.creation_country = movieDTO.getCreation_country();
    this.age_censor = movieDTO.getAge_censor();
    this.imdb_code = movieDTO.getImdb_code();
    this.rating = movieDTO.getRating();
  }

  public Movie() {}

  public void setLanguage(Language language) {
    this.language = language;
  }

  public void updateValues(MovieDTO movieDTO, Language language) {
    this.title = movieDTO.getTitle();
    this.poster_url = movieDTO.getPoster_url();
    this.release_date = movieDTO.getRelease_date();
    this.description = movieDTO.getDescription();
    this.movie_length = movieDTO.getMovie_length();
    this.creation_country = movieDTO.getCreation_country();
    this.age_censor = movieDTO.getAge_censor();
    this.imdb_code = movieDTO.getImdb_code();
    this.rating = movieDTO.getRating();
    this.language = language;
  }
}
