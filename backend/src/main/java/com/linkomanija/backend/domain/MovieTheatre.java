package com.linkomanija.backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "movie_theatre")
public class MovieTheatre {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String address;
  private String phone_number;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private Date creation_date;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @JoinColumn(name = "city_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private City city;
}
