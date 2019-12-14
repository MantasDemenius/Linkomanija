package com.linkomanija.backend.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user_employee")
public class UserEmployee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String username;
  private String password;
  private String email;
  private String name;
  private String surname;
  private Date born_date;
  private String phone_number;

  @JoinColumn(name = "movie_theatre_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private MovieTheatre movie_theatre;

  public MovieTheatre getMovie_theatre() {
    return movie_theatre;
  }
}
