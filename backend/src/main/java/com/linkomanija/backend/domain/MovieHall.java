package com.linkomanija.backend.domain;

import javax.persistence.*;

import com.linkomanija.backend.dto.MovieHallDTO;
import lombok.AllArgsConstructor;
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

  @JoinColumn(name = "movie_theatre_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private MovieTheatre movieTheatre;

  public MovieHall(MovieHallDTO movieHallDTO) {
    this.id = movieHallDTO.getId();
    this.name = movieHallDTO.getName();
    this.column_count = movieHallDTO.getColumn_count();
    this.row_count = movieHallDTO.getRow_count();
  }

  public MovieHall() {}

  public void setMovieTheatre(MovieTheatre movieTheatre) {
    this.movieTheatre = movieTheatre;
  }

  public void updateValues(MovieHallDTO movieHallDTO, MovieTheatre movieTheatreById) {
    this.id = movieHallDTO.getId();
    this.name = movieHallDTO.getName();
    this.column_count = movieHallDTO.getColumn_count();
    this.row_count = movieHallDTO.getRow_count();
    this.movieTheatre = movieTheatreById;
  }
}
