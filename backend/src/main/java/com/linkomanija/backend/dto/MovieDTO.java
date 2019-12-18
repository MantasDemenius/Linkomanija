package com.linkomanija.backend.dto;

import com.linkomanija.backend.domain.Genre;
import lombok.Data;

import java.util.List;

public class MovieDTO {
  private Long id;
  private String title;
  private String description;
  private String imdb_code;
  private Long language_id;
  private String age_censor;
  private List<Long> genre_list;
  private List<Genre> genres;

  public MovieDTO(String title, String description, String imdb_code, Long language_id, String age_censor, List<Long> genre_list) {
    this.title = title;
    this.description = description;
    this.imdb_code = imdb_code;
    this.language_id = language_id;
    this.age_censor = age_censor;
    this.genre_list = genre_list;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  public List<Long> getGenre_list() {
    return genre_list;
  }

  public void setGenres(List<Genre> genres) {
    this.genres = genres;
  }

  public List<Genre> getGenres() {
    return genres;
  }
}
