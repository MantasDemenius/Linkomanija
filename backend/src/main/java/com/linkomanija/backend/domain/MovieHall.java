package com.linkomanija.backend.domain;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "movie_hall")
public class MovieHall {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private int column_count;
  private int row_count;
  private Long movie_theatre_id;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getColumn_count() {
    return column_count;
  }

  public int getRow_count() {
    return row_count;
  }

  public Long getMovie_theatre_id() {
    return movie_theatre_id;
  }
}
