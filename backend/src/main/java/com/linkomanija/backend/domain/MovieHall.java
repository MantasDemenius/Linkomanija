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

  @Column(name = "column_count")
  private int columnCount;

  @Column(name = "row_count")
  private int rowCount;

  @JoinColumn(name = "movie_theatre_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private MovieTheatre movie_theatre;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getColumnCount() {
    return columnCount;
  }

  public int getRowCount() {
    return rowCount;
  }

  public void setColumnCount(int columnCount) {
    this.columnCount = columnCount;
  }

  public void setRowCount(int rowCount) {
    this.rowCount = rowCount;
  }

  public void setMovie_theatre(MovieTheatre movie_theatre) {
    this.movie_theatre = movie_theatre;
  }
}
