package com.linkomanija.backend.domain;

import com.linkomanija.backend.dto.MovieDTO;
import com.linkomanija.backend.omdb.ImdbMovie;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
  private double imdb_rating;
  private double user_rating;
  private Date imdb_last_updated;

  private String actor_list;
  private String writer_list;
  private String director_list;

  @JoinColumn(name = "language_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private Language language;

  @ManyToMany(cascade = {
    CascadeType.PERSIST,
    CascadeType.MERGE
  })
  @JoinTable(name = "movie_genre_link",
    joinColumns = @JoinColumn(name = "movie_id"),
    inverseJoinColumns = @JoinColumn(name = "genre_id")
  )
  private List<Genre> genreList;

  public Movie(MovieDTO movieDTO, Language language) {
    this.title = movieDTO.getTitle();
    this.description = movieDTO.getDescription();
    this.imdb_code = movieDTO.getImdb_code();
    this.age_censor = movieDTO.getAge_censor();
    this.language = language;
    this.genreList = movieDTO.getGenres();
  }

  public Movie() {}

  public Language getLanguage() {
    return language;
  }

  public Date getImdb_last_updated() {
    return imdb_last_updated;
  }

  public String getImdb_code() {
    return imdb_code;
  }

  public void updateValues(MovieDTO movieDTO, Language language) {
    this.title = movieDTO.getTitle();
    this.description = movieDTO.getDescription();
    this.imdb_code = movieDTO.getImdb_code();
    this.age_censor = movieDTO.getAge_censor();
    this.language = language;
    this.genreList = movieDTO.getGenres();
  }

  public void updateUserRating(double user_rating) {
    this.user_rating = user_rating;
  }

  public void setImdbRating(double imdb_rating) {
    this.imdb_rating = imdb_rating;
    this.imdb_last_updated = new Date(System.currentTimeMillis());
  }

  public void completeWithImdb(ImdbMovie movie) {
    this.poster_url = movie.getPoster_url();
    this.creation_country = movie.getCreation_country();
    this.movie_length = movie.getMovie_length();
    this.release_date = movie.getRelease_date();
    this.setImdbRating(movie.getImdb_rating());
    this.writer_list = movie.getWriter_list();
    this.actor_list = movie.getActor_list();
    this.director_list = movie.getDirector_list();
  }
}
