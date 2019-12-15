package com.linkomanija.backend.dto;

import java.util.Date;

public class MovieDTO {
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
  private Long language_id;

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getPoster_url() {
    return poster_url;
  }

  public Date getRelease_date() {
    return release_date;
  }

  public String getDescription() {
    return description;
  }

  public int getMovie_length() {
    return movie_length;
  }

  public String getCreation_country() {
    return creation_country;
  }

  public String getAge_censor() {
    return age_censor;
  }

  public String getImdb_code() {
    return imdb_code;
  }

  public double getRating() {
    return rating;
  }

  public Long getLanguage_id() {
    return language_id;
  }
}
