package com.linkomanija.backend.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "movie_hall")
public class MovieHall {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String columnCount;
  private String rowCount;

//  @JoinColumn(name = "movie_theatre_id")
//  @ManyToOne(fetch = FetchType.EAGER)
//  private MovieTheatre movie_theatre;
}
