package com.linkomanija.backend.omdb;

import java.util.Date;

public class ImdbMovie {
  private String poster_url;
  private int movie_length;
  private String creation_country;
  private Date release_date;
  private double imdb_rating;

  public ImdbMovie(String poster_url, int movie_length, String creation_country, Date release_date, double imdb_rating) {
    this.poster_url = poster_url;
    this.movie_length = movie_length;
    this.creation_country = creation_country;
    this.release_date = release_date;
    this.imdb_rating = imdb_rating;
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
