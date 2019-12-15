package com.linkomanija.backend.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.linkomanija.backend.dto.UserEmployeeDTO;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "movie_theatre_id")
  private MovieTheatre movieTheatre;

  public UserEmployee(UserEmployeeDTO userEmployeeDTO) {
    this.id = userEmployeeDTO.getId();
    this.username = userEmployeeDTO.getUsername();
    this.password = userEmployeeDTO.getPassword();
    this.email = userEmployeeDTO.getEmail();
    this.name = userEmployeeDTO.getName();
    this.surname = userEmployeeDTO.getSurname();
    this.born_date = userEmployeeDTO.getBorn_date();
    this.phone_number = userEmployeeDTO.getPhone_number();
  }

  public UserEmployee() {}

  public void setMovieTheatre(MovieTheatre movieTheatre) {
    this.movieTheatre = movieTheatre;
  }
}
