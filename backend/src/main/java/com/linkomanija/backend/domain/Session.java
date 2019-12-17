package com.linkomanija.backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.linkomanija.backend.dto.SessionDTO;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.thymeleaf.util.DateUtils;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "session")
public class Session {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private Date session_date;

  private String session_start;
  private String session_end;
  private int empty_spaces;
  private double price;
  private float length;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "language_id")
  private Language language;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "movie_id")
  private Movie movie;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "movie_hall_id")
  private MovieHall movieHall;

  public Session(SessionDTO sessionDTO, Language language, Movie movie, MovieHall movieHall ) {
    this.id = sessionDTO.getId();
    this.session_date = sessionDTO.getSession_date();
    this.session_start = sessionDTO.getSession_start();
    this.session_end = sessionDTO.getSession_end();
    this.empty_spaces = sessionDTO.getEmpty_spaces();
    this.price = sessionDTO.getPrice();
    this.length = sessionDTO.getLength();
    this.language = language;
    this.movie = movie;
    this.movieHall = movieHall;
  }

  public Session() {}

  public void updateValues(SessionDTO sessionDTO, Language language, Movie movie, MovieHall movieHall) {
    this.id = sessionDTO.getId();
    this.session_date = sessionDTO.getSession_date();
    this.session_start = sessionDTO.getSession_start();
    this.session_end = sessionDTO.getSession_end();
    this.empty_spaces = sessionDTO.getEmpty_spaces();
    this.price = sessionDTO.getPrice();
    this.length = sessionDTO.getLength();
    this.language = language;
    this.movie = movie;
    this.movieHall = movieHall;
  }

  public void setSession_date(Date session_date) {
    this.session_date = session_date;
  }

  public Date getSession_date() {
    return session_date;
  }
}
