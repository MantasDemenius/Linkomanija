package com.linkomanija.backend.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "movie_theatre")
public class MovieTheatre {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String address;
  private String phone_number;
  private Date creation_date;

  @JoinColumn(name = "city_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private City city;
}
