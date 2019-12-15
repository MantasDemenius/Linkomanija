package com.linkomanija.backend.domain;

import com.linkomanija.backend.dto.SessionDTO;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "session")
public class Session {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Date session_date;
  private String session_start;
  private String session_end;
  private int empty_spaces;
  private double price;
  private float length;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "language_id", referencedColumnName = "id", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Language language;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "movie_id", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Movie movie;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "movie_hall_id", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  private MovieHall movieHall;

  public Session(SessionDTO sessionDTO) {
    this.id = sessionDTO.getId();
    this.session_date = sessionDTO.getSession_date();
    this.session_start = sessionDTO.getSession_start();
    this.session_end = sessionDTO.getSession_end();
    this.empty_spaces = sessionDTO.getEmpty_spaces();
    this.price = sessionDTO.getPrice();
    this.length = sessionDTO.getLength();
  }

  public Session() {}

  public void setLanguage(Language language) {
    this.language = language;
  }

  public void setMovie(Movie movie) {
    this.movie = movie;
  }

  public void setMovieHall(MovieHall movieHall) {
    this.movieHall = movieHall;
  }
}
