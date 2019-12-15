package com.linkomanija.backend.dto;

public class MovieDTO {
  private Long id;
  private String title;
  private String description;
  private String imdb_code;
  private Long language_id;
  private String age_censor;

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public String getImdb_code() {
    return imdb_code;
  }

  public Long getLanguage_id() {
    return language_id;
  }

  public String getAge_censor() {
    return age_censor;
  }
}
