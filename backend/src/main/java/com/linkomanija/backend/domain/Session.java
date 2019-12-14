package com.linkomanija.backend.domain;

import lombok.Data;

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
  private String sessiond_end;
  private int empty_spaces; //retard name
  private double price;
  private float length; //retard name
  private Long language_id;
  private Long movie_id;
  private Long movie_hall_id;
}
