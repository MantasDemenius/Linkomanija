package com.linkomanija.backend.omdb;

import java.util.Date;

public class ImdbMovie {
  private String poster_url;
  private int movie_length;
  private String creation_country;
  private Date release_date;
  private double imdb_rating;
  private String actor_list;
  private String director_list;
  private String writer_list;

  public ImdbMovie(String actor_list, String director_list, String writer_list, String poster_url, int movie_length, String creation_country, Date release_date, double imdb_rating) {
    this.poster_url = poster_url;
    this.movie_length = movie_length;
    this.creation_country = creation_country;
    this.release_date = release_date;
    this.imdb_rating = imdb_rating;
    this.actor_list = actor_list;
    this.director_list = director_list;
    this.writer_list = writer_list;
  }

  public String getActor_list() {
    return actor_list;
  }

  public String getDirector_list() {
    return director_list;
  }

  public String getWriter_list() {
    return writer_list;
  }

  public String getPoster_url() {
    return poster_url;
  }

  public int getMovie_length() {
    return movie_length;
  }

  public String getCreation_country() {
    return creation_country;
  }

  public Date getRelease_date() {
    return release_date;
  }

  public double getImdb_rating() {
    return imdb_rating;
  }
}
